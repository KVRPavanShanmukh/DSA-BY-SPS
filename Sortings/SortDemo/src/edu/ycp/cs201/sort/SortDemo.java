package edu.ycp.cs201.sort;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.JTextField;

public class SortDemo extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private class SortDemoSequence implements Sequence<Integer> {
		private Integer[] storage;
		private int highlighted;
		private boolean write;
		
		public SortDemoSequence(int size) {
			storage = new Integer[size];
			randomize();
		}
		
		public Integer get(int index) {
			highlighted = index;
			write = false;
			animateOneStep();
			return storage[index];
		}
		
		public Integer peek(int index) {
			return storage[index];
		}
		
		public void put(int index, Integer value) {
			if (value == null) throw new IllegalArgumentException();
			storage[index] = value;
			highlighted = index;
			write = true;
			animateOneStep();
		}
		
		public void swap(int index1, int index2) {
			Integer tmp = get(index1);
			put(index1, get(index2));
			put(index2, tmp);
		}
		
		public int size() {
			return storage.length;
		}
		
		public int getHighlighted() {
			return highlighted;
		}
		
		public boolean isWrite() {
			return write;
		}
		
		private void animateOneStep() {
			//System.out.println("Tick");
			SwingUtilities.invokeLater(new Runnable(){
				public void run() {
					animationCanvas.repaint();
					++numOperations;
					operationCountBox.setText("" + numOperations);
				}
			});
			synchronized (SortDemo.this) {
				long now = tick;
				while (tick < now + 1) {
					try {
						SortDemo.this.wait();
					} catch (InterruptedException e) {
						// ignore
					}
				}
			}
		}

		public void randomize() {
			ArrayList<Integer> contents = new ArrayList<Integer>();
			for (int i = 0; i < size(); i++) {
				contents.add(i + 1);
			}
			Collections.shuffle(contents);
			
			storage = contents.toArray(new Integer[size()]);
			highlighted = -1;
		}
	}
	
	private class AnimationCanvas extends JPanel {
		private static final long serialVersionUID = 1L;

		public AnimationCanvas() {
			setBackground(Color.BLACK);
		}
		
		public void paint(Graphics g) {
			super.paint(g);
			
			for (int i = 0; i < sequence.size(); i++) {
				int value = sequence.peek(i);
				double scaledLen = ((double)value / ((double)sequence.size()+1)) * getWidth();

				Color color;
				if (i == sequence.getHighlighted()) {
					color = sequence.isWrite() ? Color.RED : Color.GREEN;
				} else {
					color = Color.BLUE;
				}

				g.setColor(color);
				
				g.fillRect(1, i * (getBarGap() + getBarSize()) + 1, (int) (scaledLen), getBarSize());
			}
		}
	}
	
//	private static final int BAR_SIZE = 3;
//	private static final int BAR_GAP = 1;
	private static final int ANIM_DELAY = 25;

	private JPanel jContentPane = null;
	private JPanel animationCanvas = null;
	private JButton randomizeButton = null;
	private JButton sortButton = null;
	private JButton problemSizeButton = null;
	private JComboBox sortSelector = null;
	private JTextField operationCountBox = null;
	private Timer timer;
	private long tick;
	
	private ArrayList<Sort<Integer>> sortList;
	private SortDemoSequence sequence;
	private int numOperations;
	private Thread sortThread;

	/**
	 * This is the default constructor
	 */
	public SortDemo() {
		super();
		initialize();
		
		sortList = new ArrayList<Sort<Integer>>();
		
		createSequence();
		
		timer = new Timer(ANIM_DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized (SortDemo.this) {
					++tick;
					SortDemo.this.notify();
				}
			}
		});
		
		timer.start();
		
		configureSortingAlgorithms();
	}

	private void createSequence() {
		sequence = new SortDemoSequence(animationCanvas.getHeight() / (getBarSize() + getBarGap()));
		sequence.randomize();
	}

	public int getBarSize() {
		return (problemSizeButton.getText().equals("Small") ? 6 : 3);
	}

	public int getBarGap() {
		return (problemSizeButton.getText().equals("Small") ? 2 : 1);
	}

	private void configureSortingAlgorithms() {
		sortList.add(new ShellSort<Integer>());
		sortList.add(new InsertionSort<Integer>());
		sortList.add(new BubbleSort<Integer>());
		sortList.add(new QuickSort<Integer>());
		sortList.add(new MergeSort<Integer>());
		
		for (Sort<?> sort : sortList) {
			sortSelector.addItem(sort.toString());
		}
	}

	private void initialize() {
		this.setSize(600, 400);
		this.setContentPane(getJContentPane());
		this.setTitle("Sort Demo");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getAnimationCanvas(), null);
			jContentPane.add(getRandomizeButton(), null);
			jContentPane.add(getProblemSizeButton(), null);
			jContentPane.add(getSortSelector(), null);
			jContentPane.add(getSortButton(), null);
			jContentPane.add(getOperationCountBox(), null);
		}
		return jContentPane;
	}

	private JPanel getAnimationCanvas() {
		if (animationCanvas == null) {
			animationCanvas = new AnimationCanvas();
			animationCanvas.setSize(new java.awt.Dimension(581,326));
			animationCanvas.setLocation(new java.awt.Point(4,4));
		}
		return animationCanvas;
	}

	private JButton getRandomizeButton() {
		if (randomizeButton == null) {
			randomizeButton = new JButton();
			randomizeButton.setLocation(new java.awt.Point(12,334));
			randomizeButton.setText("Random");
			randomizeButton.setSize(new java.awt.Dimension(98,32));
			randomizeButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (!sortThreadRunning()) {
						sequence.randomize();
						animationCanvas.repaint();
					}
				}
			});
		}
		return randomizeButton;
	}

	private JButton getSortButton() {
		if (sortButton == null) {
			sortButton = new JButton();
			sortButton.setLocation(new java.awt.Point(119,334));
			sortButton.setText("Sort!");
			sortButton.setSize(new java.awt.Dimension(98,32));
			sortButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (!sortThreadRunning()) {
						sortThread = new Thread() {
							public void run() {
								int index = sortSelector.getSelectedIndex();
								if (index >= 0 && index < sortList.size()) {
									Sort<Integer> sort = sortList.get(index);
									
									numOperations = 0;
									operationCountBox.setText("" + numOperations);
									
									//System.out.println("Sorting...");
									
									sort.sort(sequence, new Comparator<Integer>() {
										public int compare(Integer o1, Integer o2) {
											return o1.compareTo(o2);
										}
									});
									
									//System.out.println("Done sorting");
									
									SwingUtilities.invokeLater(new Runnable() {
										public void run() {
											sortThreadRunning();
										}
									});
								}
							}
						};
						
						sortButton.setText("Running");
						
						sortThread.start();
					}
				}
			});
		}
		return sortButton;
	}
	
	private JButton getProblemSizeButton() {
		if (problemSizeButton == null) {
			problemSizeButton = new JButton();
			problemSizeButton.setLocation(new Point(236, 334));
			problemSizeButton.setText("Small");
			problemSizeButton.setSize(new java.awt.Dimension(98,32));
			problemSizeButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if (!sortThreadRunning()) {
						String val = problemSizeButton.getText();
						problemSizeButton.setText(val.equals("Small") ? "Large" : "Small");
						createSequence();
						animationCanvas.repaint();
					}
				}
			});
		}
		return problemSizeButton;
	}

	private JComboBox getSortSelector() {
		if (sortSelector == null) {
			sortSelector = new JComboBox();
			sortSelector.setSize(new java.awt.Dimension(120,32));
			sortSelector.setLocation(new java.awt.Point(450,334));
		}
		return sortSelector;
	}

	private boolean sortThreadRunning() {
		if (sortThread == null) {
			return false;
		}
		
		if (!sortThread.isAlive()) {
			sortThread = null;
			sortButton.setText("Sort!");
			return false;
		}
		
		return true;
	}
	
	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getOperationCountBox() {
		if (operationCountBox == null) {
			operationCountBox = new JTextField();
			operationCountBox.setBounds(new java.awt.Rectangle(374,334,65,32));
			operationCountBox.setEditable(false);
		}
		return operationCountBox;
	}

	public static void main(String[] args) {
		SortDemo sortDemo = new SortDemo();
		sortDemo.setVisible(true);
	}

}

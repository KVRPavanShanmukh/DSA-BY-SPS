/*
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:

Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
 

Example 1:

Input
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
Output
[null, null, [5], null, null, [6, 5], null, [5]]

Explanation
Twitter twitter = new Twitter();
twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
twitter.follow(1, 2);    // User 1 follows user 2.
twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.unfollow(1, 2);  // User 1 unfollows user 2.
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

    Map<Integer, List<int[]>> hm1; // userId -> list of [time, tweetId]
    Map<Integer, Set<Integer>> hm2; // followerId -> set of followeeIds
    int time;

    public Twitter() {
        hm1 = new HashMap<>();
        hm2 = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        hm1.putIfAbsent(userId, new ArrayList<>());
        hm1.get(userId).add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        // Use a Max-Heap based on time descending (most recent on top)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Add user's own tweets
        if (hm1.containsKey(userId)) {
            pq.addAll(hm1.get(userId));
        }

        // Add tweets from people the user follows
        if (hm2.containsKey(userId)) {
            for (int followeeId : hm2.get(userId)) {
                if (hm1.containsKey(followeeId)) {
                    pq.addAll(hm1.get(followeeId));
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            res.add(pq.poll()[1]);
            count++;
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        hm2.putIfAbsent(followerId, new HashSet<>());
        hm2.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (hm2.containsKey(followerId)) {
            hm2.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter tw = new Twitter();

        tw.postTweet(1, 2);
        tw.postTweet(2, 6);

        System.out.println(tw.getNewsFeed(1)); // [2]
        tw.follow(1, 2);
        System.out.println(tw.getNewsFeed(1)); // [6,2]
        tw.unfollow(1, 2);
        tw.postTweet(1, 7);
        System.out.println(tw.getNewsFeed(1)); // [7,2]
    }
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

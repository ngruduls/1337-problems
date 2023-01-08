import java.util.*;
import java.util.stream.Collectors;

class Twitter {
    Database db;
    public Twitter() { this.db = new Database();}
    public void postTweet(int userId, int tweetId) {this.db.postTweet(userId,tweetId);}
    public List<Integer> getNewsFeed(int userId) {return db.getMaxTop10TweetIDs(userId);}
    public void follow(int followerId, int followeeId) {this.db.follow(followerId,followeeId);}
    public void unfollow(int followerId, int followeeId) {this.db.unfollow(followerId,followeeId);}
}

class User{
    int uid;
    Set<Integer> following;
    List<Integer> tweets;
    public User(int uid) { this.uid = uid;
        this.following = new HashSet<>(); this.following.add(this.uid);
        this.tweets = new ArrayList<>();}
    @Override
    public String toString() { return "User{" + "uid=" + uid + ", following=" + following + ", tweets=" + tweets + '}';}
    public void follow(int fid) {this.following.add(fid);}
    public void unfollow(int fid) {this.following.remove(fid);}
    public void postTweet(int tweetID) {this.tweets.add(tweetID);}
}

class Tweet {
    int tweetID; int timestamp;
    public Tweet(int tweetID, int timestamp) { this.tweetID = tweetID; this.timestamp = timestamp;}
    @Override public String toString() {return "{" + this.tweetID + "," + this.timestamp + "}";}
}

class Database {
    static int GLOBAL_TIME = 0; final int NUM_USERS = 501; // can use hashmap for larger
    User[] users;
    boolean[] userExists;
    final int NUM_TWEETS = 10000 + 1;
    Tweet[] tweets;
    public Database() {
        this.users = new User[NUM_USERS];
        this.userExists = new boolean[NUM_USERS];
        Arrays.fill(this.userExists, false);
        this.tweets = new Tweet[NUM_TWEETS];
        this.tweet_comparator = new TweetComparator();
    }
    private void createUserIfNotExists(int uid) {
        if (this.userExists[uid]) return;
        User newUser = new User (uid); this.users[uid] = newUser; this.userExists[uid] = true;
    }
    private void createTweetWithGlobalTime(int tweetID) {
        Tweet tweet = new Tweet(tweetID, Database.GLOBAL_TIME);
        Database.GLOBAL_TIME++;
        this.tweets[tweetID] = tweet;
    }
    public void postTweet(int uid, int tweetID) {
        createUserIfNotExists(uid);
        createTweetWithGlobalTime(tweetID);
        this.users[uid].postTweet(tweetID);
    }
    public void follow(int followerID, int followeeID) {
        createUserIfNotExists(followerID);
        createUserIfNotExists(followeeID);
        this.users[followerID].follow(followeeID);
    }
    public void unfollow(int followerID, int followeeID) {
        createUserIfNotExists(followerID);
        createUserIfNotExists(followeeID);
        this.users[followerID].unfollow(followeeID);
    }
    private List<Tweet> getMaxTopK(int userId, int k) {
        if (!this.userExists[userId]) return new ArrayList<>();
        PriorityQueue<Triplet> pq = new PriorityQueue<>(this.tweet_comparator);
        User user = this.users[userId];
        Set<Integer> following = user.following;
        for (int followingID : following) {
            User followingUser = this.users[followingID];
            if (followingUser.tweets.isEmpty()) continue;
            int mostRecentTweetID = followingUser.tweets.get(followingUser.tweets.size()-1);
            Triplet lastTweetFromEachofFollowing = new Triplet(followingID, followingUser.tweets.size()-1, mostRecentTweetID);
            pq.add(lastTweetFromEachofFollowing);
        }
        List<Tweet> maxTweets = new ArrayList<>();
        while (!pq.isEmpty() && (maxTweets.size() < k)) {
            Triplet top = pq.remove();
            maxTweets.add(tweets[top.tweetID]);
            int userID = top.userId;
            if (top.index - 1 < 0) continue;
            int newTweetID = users[userID].tweets.get(top.index - 1);
            Triplet newTriplet = new Triplet(userID, top.index - 1, newTweetID);
            pq.add(newTriplet);
        }
        return maxTweets;
    }
    public List<Integer> getMaxTop10TweetIDs(int userId) {
        List<Tweet> tweets = getMaxTopK(userId, 10);
        return tweets.stream().map (x -> x.tweetID).collect(Collectors.toList());
    }
    class Triplet {
        int userId; int index; int tweetID;
        public Triplet(int userId, int index, int tweetID) {this.userId = userId; this.index = index; this.tweetID = tweetID;}
        @Override
        public String toString() {return "Triplet{" + "userId=" + userId + ", index=" + index + ", tweetID=" + tweetID + '}'; }
    }
    class TweetComparator implements Comparator<Triplet> {
        @Override
        public int compare(Triplet o1, Triplet o2) {
            return (tweets[o2.tweetID].timestamp - tweets[o1.tweetID].timestamp) ;
        }
    }

    private TweetComparator tweet_comparator;
}

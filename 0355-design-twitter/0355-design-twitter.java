class Tweet {
    int tweetId;
    int time;
    Tweet next;

    public Tweet(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
        next = null;
    }
}

class User {
    int userId;
    Set<Integer> following;
    Tweet head;

    public User(int userId) {
        this.userId = userId;
        following = new HashSet<>();
        head = null;
        follow(userId);
    }

    public void follow(int followeeId) {
        following.add(followeeId);
    }

    public void unFollow(int followeeId) {
        if (userId != followeeId) {
            following.remove(followeeId);
        }
    }

    public void post(int tweetId, int time) {
        Tweet tweet = new Tweet(tweetId, time);
        tweet.next = head;
        head = tweet;
    }
}

class Twitter {
    Map<Integer, User> map;
    int time;

    public Twitter() {
        map = new HashMap<>();    
        time = 1;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!map.containsKey(userId)) {
            map.put(userId, new User(userId));
        }

        map.get(userId).post(tweetId, time++);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!map.containsKey(userId)) return res;

        Set<Integer> following =  map.get(userId).following;
        PriorityQueue<Tweet> queue = new PriorityQueue<>((a, b) -> {
            return b.time - a.time; // 时间大的就是最新的
        });

        for (int followeeId: following) {
            Tweet tweet = map.get(followeeId).head;
            if (tweet != null) {
                queue.add(tweet);
            }
        }

        while (!queue.isEmpty()) {
            if (res.size() == 10) break;

            Tweet mostRecentTweet = queue.poll();
            res.add(mostRecentTweet.tweetId);

            if (mostRecentTweet.next != null) {
                queue.add(mostRecentTweet.next);
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) {
            map.put(followerId, new User(followerId));
        }

        if (!map.containsKey(followeeId)) {
            map.put(followeeId, new User(followeeId));
        }

        map.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (map.containsKey(followerId)) {
            map.get(followerId).unFollow(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
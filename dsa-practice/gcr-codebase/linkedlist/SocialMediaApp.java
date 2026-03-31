// Friend List Node (Nested Linked List)
class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

// User Node (Main Linked List)
class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friends; // Head of friend list
    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
        this.next = null;
    }
}

// Social Media Manager using Singly Linked List
class SocialMediaManager {

    private UserNode head;

    // Add new user
    public void addUser(int id, String name, int age) {
        UserNode newUser = new UserNode(id, name, age);
        newUser.next = head;
        head = newUser;
    }

    // Search user by ID
    private UserNode findUserById(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Search user by Name
    public void searchUserByName(String name) {
        UserNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: " +
                        temp.userId + " | " + temp.name + " | " + temp.age);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("User not found");
    }

    // Add friend connection (both ways)
    public void addFriend(int userId1, int userId2) {
        UserNode u1 = findUserById(userId1);
        UserNode u2 = findUserById(userId2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        addFriendToList(u1, userId2);
        addFriendToList(u2, userId1);

        System.out.println("Friend connection added");
    }

    private void addFriendToList(UserNode user, int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = user.friends;
        user.friends = newFriend;
    }

    // Remove friend connection
    public void removeFriend(int userId1, int userId2) {
        UserNode u1 = findUserById(userId1);
        UserNode u2 = findUserById(userId2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        removeFriendFromList(u1, userId2);
        removeFriendFromList(u2, userId1);

        System.out.println("Friend connection removed");
    }

    private void removeFriendFromList(UserNode user, int friendId) {
        FriendNode temp = user.friends;
        FriendNode prev = null;

        while (temp != null) {
            if (temp.friendId == friendId) {
                if (prev == null)
                    user.friends = temp.next;
                else
                    prev.next = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    // Display friends of a user
    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        FriendNode temp = user.friends;

        if (temp == null) {
            System.out.println("No friends");
            return;
        }

        while (temp != null) {
            System.out.println("Friend ID: " + temp.friendId);
            temp = temp.next;
        }
    }

    // Find mutual friends
    public void findMutualFriends(int userId1, int userId2) {
        UserNode u1 = findUserById(userId1);
        UserNode u2 = findUserById(userId2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("Mutual Friends:");
        FriendNode f1 = u1.friends;
        boolean found = false;

        while (f1 != null) {
            FriendNode f2 = u2.friends;
            while (f2 != null) {
                if (f1.friendId == f2.friendId) {
                    System.out.println("Friend ID: " + f1.friendId);
                    found = true;
                }
                f2 = f2.next;
            }
            f1 = f1.next;
        }

        if (!found)
            System.out.println("No mutual friends");
    }

    // Count number of friends for each user
    public void countFriends() {
        UserNode temp = head;

        while (temp != null) {
            int count = 0;
            FriendNode f = temp.friends;
            while (f != null) {
                count++;
                f = f.next;
            }
            System.out.println(temp.name + " has " + count + " friends");
            temp = temp.next;
        }
    }
}

// Class name is NOT Main
public class SocialMediaApp {
    public static void main(String[] args) {

        SocialMediaManager sm = new SocialMediaManager();

        sm.addUser(1, "Ankit", 21);
        sm.addUser(2, "Ravi", 22);
        sm.addUser(3, "Neha", 20);
        sm.addUser(4, "Amit", 23);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 3);
        sm.addFriend(2, 4);

        sm.displayFriends(1);

        sm.findMutualFriends(1, 2);

        sm.removeFriend(1, 2);

        sm.displayFriends(1);

        sm.searchUserByName("Neha");

        sm.countFriends();
    }
}

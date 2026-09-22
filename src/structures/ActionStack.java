package structures;

import java.util.Stack;

public class ActionStack {

    private Stack<String> actions;

    public ActionStack() {
        actions = new Stack<>();
    }

    // Push a new action description onto the stack
    public void pushAction(String actionDescription) {
        actions.push(actionDescription);
    }

    // Display recent actions, most recent first
    public void displayActions() {
        if (actions.isEmpty()) {
            System.out.println("No recent actions.");
            return;
        }
        System.out.println("\n--- Recent Actions (most recent first) ---");
        for (int i = actions.size() - 1; i >= 0; i--) {
            System.out.println(actions.get(i));
        }
    }

    public boolean isEmpty() {
        return actions.isEmpty();
    }
}
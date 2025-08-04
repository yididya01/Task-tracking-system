package src.main.java.com.ttracker.service;

// import src.main.java.com.ttracker.models.StandardUser;
// import src.main.java.com.ttracker.models.Task;

// public class PointManager {


//     public void awardPoints(Task task) {
//         try {
//             StandardUser user = task.assignedUser;
//             float oldPoints = user.getTaskPoints();
//             user.setTaskPoints(oldPoints + task.taskPoints);
//             System.out.println("Points awarded: " + task.taskPoints + " to " + user.getUsername());
//         } catch (Exception e) {
//             System.err.println("Error awarding points: " + e.getMessage());
//         }
//     }


//     public void deductPoints(Task task, float deduction) {
//         try {
//             StandardUser user = task.assignedUser;
//             float updated = user.getTaskPoints() - deduction;
//             if (updated < 0)
//                 updated = 0;
//             user.setTaskPoints(updated);
//             System.out.println("Deducted points: " + deduction + " from " + user.getUsername());
//         } catch (Exception e) {
//             System.err.println("Error deducting points: " + e.getMessage());
//         }
//     }
// }

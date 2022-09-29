package theme05_Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10_SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("course start")) {
            String[] commandLine = input.split(":");
            String command = commandLine[0];
            String item = commandLine[1];
            //add the lesson to the end of the schedule, if it does not exist
            if ("Add".equals(command)) {
                if (!lessons.contains(item)) {
                    lessons.add(item);
                }
                //insert the lesson to the given index, if it does not exist
            } else if ("Insert".equals(command)) {
                int index = Integer.parseInt(commandLine[2]);
                if (!lessons.contains(item)) {
                    lessons.add(index, item);
                }

            } else if ("Remove".equals(command)) {
                lessons.remove(item);

                //change the place of the two lessons, if they exist
            } else if ("Swap".equals(command)) {
                String firstLesson = item;
                String secondLesson = commandLine[2];
                if (lessons.contains(firstLesson) && lessons.contains(secondLesson)) {
                    int indexOfFirstLesson = getElementIndex(lessons, firstLesson);
                    int indexOfSecondLesson = getElementIndex(lessons, secondLesson);
                    lessons.set(indexOfFirstLesson, secondLesson);
                    moveExerciseAfterLesson(lessons, firstLesson, indexOfFirstLesson, indexOfSecondLesson);
                    lessons.set(indexOfSecondLesson, firstLesson);
                    moveExerciseAfterLesson(lessons, secondLesson, indexOfSecondLesson, indexOfFirstLesson);
                }

                //add Exercise in the schedule right after the lesson index,
                // if the lesson exists and there is no exercise already
                //If the lesson doesn't exist,
                // add the lesson at the end of the course schedule, followed by the Exercise.
            } else if ("Exercise".equals(command)) {
                String exerciseName = item + "-Exercise";
                if (!lessons.contains(exerciseName)) {
                    if (lessons.contains(item)) {
                        int lessonIndex = getElementIndex(lessons, item);
                        lessons.add(lessonIndex + 1, exerciseName);
                    } else {
                        lessons.add(item);
                        lessons.add(exerciseName);
                    }

                }
            }

            input = scanner.nextLine();
        }


//        System.out.println(lessons.toString());

        //•	Print the whole course schedule, each lesson on a new line with its number(index) in the schedule:
        //"{lesson index}.{lessonTitle}".

        for (int i = 0; i < lessons.size(); i++) {
            System.out.println(i+1 + "." + lessons.get(i));

        }

    }

    private static int getElementIndex(List<String> list, String element) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(element)) {
                return i;
            }
        }
        return -1;
    }

    private static void moveExerciseAfterLesson(List<String> lessons, String lessonName, int oldIndexOfLesson, int newIndexOfLesson) {
        if (oldIndexOfLesson + 1 < lessons.size()) {
            if (lessons.get(oldIndexOfLesson + 1).equals((lessonName + "-Exercise"))) {
                lessons.add(newIndexOfLesson + 1, (lessonName + "-Exercise"));
                if (oldIndexOfLesson < newIndexOfLesson) {
                    lessons.remove(oldIndexOfLesson + 1);
                } else {
                    lessons.remove(oldIndexOfLesson + 2);
                }
            }
        }
    }

}

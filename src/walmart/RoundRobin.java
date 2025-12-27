package walmart;

import java.util.*;

class Process {
    String name;
    int burstTime;
    int remainingTime;
    int waitingTime = 0;
    int turnaroundTime = 0;

    public Process(String name, int burstTime) {
        this.name = name;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        List<Process> processes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter process name: ");
            String name = sc.next();
            System.out.print("Enter burst time for " + name + ": ");
            int bt = sc.nextInt();
            processes.add(new Process(name, bt));
        }

        System.out.print("Enter time quantum: ");
        int quantum = sc.nextInt();

        roundRobin(processes, quantum);
        sc.close();
    }

    public static void roundRobin(List<Process> processes, int quantum) {
        int time = 0;
        Queue<Process> queue = new LinkedList<>(processes);

        while (!queue.isEmpty()) {
            Process p = queue.poll();

            if (p.remainingTime > quantum) {
                time += quantum;
                p.remainingTime -= quantum;
                System.out.println(p.name + " executed for " + quantum + " units; remaining " + p.remainingTime);
                queue.offer(p);  // put it back for next round
            } else {
                time += p.remainingTime;
                p.waitingTime = time - p.burstTime;
                p.turnaroundTime = time;
                System.out.println(p.name + " completed at time " + time);
                p.remainingTime = 0;
            }
        }

        System.out.println("\n--- Final Results ---");
        double totalWT = 0, totalTAT = 0;
        for (Process p : processes) {
            System.out.println(p.name + " -> Waiting Time: " + p.waitingTime + ", Turnaround Time: " + p.turnaroundTime);
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }

        System.out.printf("\nAverage Waiting Time = %.2f", totalWT / processes.size());
        System.out.printf("\nAverage Turnaround Time = %.2f\n", totalTAT / processes.size());
    }
}


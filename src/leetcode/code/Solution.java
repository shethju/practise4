package leetcode.code;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        ConsoleProcessor processor = new ConsoleProcessor();
        processor.processAllLines();
    }
}

class ConsoleProcessor {

    public OrgChart orgChart = new OrgChart();

    public void processAllLines() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        Integer numLines = 0;

        try {
           numLines = Integer.valueOf(line.trim());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < numLines; i++) {
            processLine(in.nextLine());
        }

        in.close();
    }

    protected void processLine(String line) {
        String[] parsedCommand = line.split(",");

        // ignore empty lines
        if (parsedCommand.length == 0) {
            return;
        }

        switch (parsedCommand[0]) {
            case "add":
                orgChart.add(parsedCommand[1], parsedCommand[2], parsedCommand[3]);
                //orgChart.print();
                break;
            case "print":
                orgChart.print();
                break;
            case "remove":
                orgChart.remove(parsedCommand[1]);
                break;
            case "move":
                orgChart.move(parsedCommand[1], parsedCommand[2]);
                break;
            case "count":
                System.out.println(orgChart.count(parsedCommand[1]));
                break;
        }
    }
}

class OrgChart {
    Set<String> allEmployees = new HashSet<>();
    List<Employee> org = new ArrayList<>();
    public void add(String id, String name, String managerId)
    {
        if (allEmployees.contains(id)) return;
        if (!allEmployees.contains(managerId)) {
            managerId = "-1";
        }
        Employee e = new Employee(id, name, managerId);
        if (!allEmployees.contains(managerId) || managerId == "-1") {
            org.add(e);
        } else {
            Employee mgr = findEmployee(managerId);
            if (mgr == null) {
                org.add(e);
                return;
            } else {
                List<Employee> reports = mgr.reports;
                if (reports == null) {
                    reports = new ArrayList<>();
                    reports.add(e);
                }
            }
        }
    }

    private Employee findEmployee(String empToSearch) {
        //Employee e = null;
        //Set<Employee> empSet = org.keySet();
        Queue<Employee> q = new LinkedList<>();
        q.addAll(org);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i < size; i++) {
                Employee n = q.poll();
                if (n.id == empToSearch) {
                    return n;
                }
                q.addAll(n.reports);
            }
        }
        return null;
    }

    public void print()
    {
        Queue<Employee> q = new LinkedList<>();
        q.addAll(org);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i < size; i++) {
                Employee n = q.poll();
                dfsUtil(n);
            }
        }
    }

    private void dfsUtil(Employee e) {
        if (e == null) {
            return;
        }
        System.out.println(e.name);
        List<Employee> list = e.reports;
        if (list != null) {
	        for (Employee tmp: list) {
	            dfsUtil(tmp);
	        }
        }
    }

    public void remove(String employeeId)
    {
        throw new UnsupportedOperationException();
    }

    public void move(String employeeId, String newManagerId)
    {
        throw new UnsupportedOperationException();
    }

    public int count(String employeeId)
    {
        return allEmployees.size();
    }
}

class Employee {
    String id;
    String managerId;
    String name;
    List<Employee> reports;
    public Employee(String id, String name, String managerId) {
        this.id = id;
        this.managerId = managerId;
        this.name = name;
    }
}


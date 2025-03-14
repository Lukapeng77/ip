# **Luka Task Manager User Guide**

Welcome to **Luka**, your personal task manager chatbot!
Luka is designed to help users manage their tasks efficiently.
It allows users to add, delete, mark tasks as done or not done, find tasks by searching for keywords and return the
tasks based on the specific date and time.

## **Table of Contents**

1. [Main Features](#main-features)
2. [Getting Started](#getting-started)
3. [Available Commands](#available-commands)
    - [Adding a Task](#adding-a-task)
    - [Listing All Tasks](#listing-all-tasks)
    - [Marking a Task as Done](#marking-a-task-as-done)
    - [Marking a Task as Not Done](#marking-a-task-as-not-done)
    - [Deleting a Task](#deleting-a-task)
    - [Finding a Task](#finding-a-task)
    - [Checking certain date of the task](#checking-certain-date-of-the-task)
5. [Exiting the Application](#exiting-the-application)

## Main Features

- **Add Tasks**: Users can add three types of tasks - todos, deadlines, and events.
- **Delete Tasks**: Users can delete tasks they no longer need.
- **Mark/Unmark Tasks**: Users can mark tasks as done or not done.
- **Find Tasks**: Users can search for tasks by keywords.
- **List Tasks**: Users can view all their current tasks.
- **Check Date on Tasks**: Users can check a certain date and time among tasks.

## Getting Started

1. Make sure you have **Java 17 or higher** installed on your system.
2. Run Luka using:
   ```sh
   java -jar Luka.jar
   ```
   Upon running the command successfully, you should see the following welcome message in your command line.
    ```
    Hello! I'm Luka
    What can I do for you?
   ```

## Task Types

- Todo: task that does not have a specific deadline or time range.
- Deadline: a task that needs to be done before a specific date.
- Event: a task with specified start time and end time.

## Available Commands

### Adding a Task

- Todo: `todo [task description]`

  _e.g. adding task todo `read book`_
    ```
    todo read book
    ```

- Deadline: `deadline [task description] /by [date]`

  _e.g. adding task deadline `return book` before `2024-03-14 1800`_
    ```
    deadline return book /by 2024-03-14 1800
    ```

- Event: `event [task description] /from [date] /to [date]`

  _e.g. adding task event `project meeting` from `2024-03-14 1800` to `2024-03-14 2000`_
    ```
    event project meeting /from 2024-03-14 1800 /to 2024-03-14 2000
    ```

### Expected output for all adding tasks

    Got it. I've added this task:
       [E][ ] event project meeting /from 2024-03-14 1800 /to 2024-03-14 2000
    Now you have 3 tasks in the list.

> Note: the following e.g. for each command below will use the output of the above prompts for illustration.
> You may also notice the printed date time is different from the input format, the main idea is
> we store the date as LocalDateTime here instead of String[^1].

## Listing all tasks

### Prompt: `list`

_e.g. listing all tasks_

```
list
```

### Expected output

    Here are the tasks in your list:
    1. [T][ ] read book
    2. [D][ ] return book (by: Mar 14 2024, 06:00 pm)
    3. [E][ ] project meeting (from:  Mar 14 2024 06:00 pm to: Mar 14 2024, 08:00 pm)
    Now you have 3 tasks in the list.

## Deleting a task

### Prompt: `delete [task number]`

_e.g. deleting 3_

```
delete 3
```

### Expected output

    Noted. I've removed this task:
      [E][ ]project meeting (from: 2024-03-14 1800 to: 2024-03-14 2000)
    this can be verified by listing all tasks:

    list
    Here are the tasks in your list:
    1. [T][ ] read book
    2. [D][ ] return book (by: Sep 17 2021)

## Marking a task as done

### Prompt: `mark {task index}`

_e.g. mark 1_

```
mark 1
```

### Expected output

    Nice! I've marked this task as done: 
     [T][X]read book 

## Marking a task as not done

### Prompt: `unmark {task index}`

_e.g. unmarking 1

  ```
  unmark 1
  ```

### Expected output

  ```
  Ok, I've unmarked this task as done: 
    [T][ ] read book 
  ```

## Finding a task

### Prompt: `find [keyword]`

e.g. finding tasks related to `book`

```
find book
```

### Expected output

    Here are the matching tasks in your list:
    1. [T][ ] read book
    2. [D][ ] return book (by: 2024-03-14 1800)

## Checking certain date of the task

### Prompt: `checkDate [date]`[^2]

e.g. checking tasks due on `2024-03-14`

```
checkDate 2024-03-14 1800
```

### Expected output

  ```
  Here are the list of tasks that are due on  Mar 14 2024, 06:00 pm :
  1. [D][ ] return book (by:  Mar 14 2024, 06:00 pm )
  You have 1 tasks in the list.
  ```

## Exiting the Application

### Exit Program Prompt: `bye`

### Expected output

  ```
  Bye. Hope to see you again soon!
  ```

> [NOTE]
> Useful information users should know in terms of task data storage:
> - Saving of task data: <br/>
The program saves the data in the task list to the hard disk after every command. There is no need to save manually.
The task list data is saved in the file `[JAR file location]/data/luka.txt`.
> - Loading of task data:<br/>
When the program is initialised, it loads the data from the saved file into the task list. If the saved file does not
exist, the program creates an empty file and its directory at the file path.

[^1]: Treat the date time as LocalDateTime type makes it more meaningful.

[^2]: Here for the input date string, we support three main input formats: `yyyy-MM-dd HHmm`, `dd/MM/yyyy HHmm`,
`dd-MM-yyyy HHmm`.
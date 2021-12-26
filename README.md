# StudyBuddy
*Taking time management to the next level*

*A Java application to allow university students develop effective study habits*

*Contains a console-based component and a GUI component*

## Description

With the immense workload of university students, effective studying and time management become essential 
to success. This is why I built **StudyBuddy**, an interactive app allowing university students 
to track club dates, course dates, and the practice questions they complete for their courses. 

For many university courses, independent practice is essential to performing well in exams. 
To ensure academic success, the main feature of **StudyBuddy** allows its users to create topics for 
each of their courses and assign a *minimum* of three relevant practice questions to each topic. 
The aim of this feature is to encourage students to identify exam-worthy subjects and then 
do a minimum of three practice problems per each topic so that they can master what they are taught in lectures.
With this set-up, **StudyBuddy** will help students manage their time more effectively, make their 
learning more efficient, and hopefully reduce their exam-related stress.
 
## Phase 1 User Stories
- I want to add multiple Dates to my Clubs and Courses.
- I want to classify my Dates as an EXAM, PROJECT, MEETING, or OTHER.
- I want to add multiple reminders to my Clubs.
- I want to add multiple Topics to my Courses.
- I want to keep track of the number of practice questions I have completed for a Topic.
- I want to keep track of the number of practice questions I need to complete for a Topic.
## Phase 2 User Stories
- I want to save my clubs to file.
- I want to save my courses to file.
- I want to reload my clubs from file.
- I want to reload my courses from file.

## Phase 3 User Stories
- I want to add multiple Courses to my GUI.
- I want to add multiple Topics to my Course.
- I want to remove Topics from my Course.
- I want to complete questions for a Topic in my Course.
- I want to save my changes to file.
- I want to load my saved changes from file.
 
## Phase 4: Task 2
Here is a description of the events that occur when StudyBuddy runs:
- User adds a Topic to a Course: EventLog logs an Event with the description "Added TOPIC NAME to COURSE NAME".
- User removes a Topic to a Course: EventLog logs an Event with the description "Removed TOPIC NAME from COURSE NAME".
- User completes a question for a Topic of a Course: EventLog logs an Event with the description 
"Completed a question for TOPIC NAME in COURSE NAME".

Here is a sample of what might get printed to the console after user quits StudyBuddy:

- *Tue Nov 23 16:03:19 PST 2021
Added Design to CPSC 210*

- *Tue Nov 23 16:03:24 PST 2021
Completed a question for Design in CPSC 210*

- *Tue Nov 23 16:03:25 PST 2021
Removed Design from CPSC 210*

## Phase 4: Task 3
If I had  time to refactor my project, here are the top two things I would do:
- **Improving the cohesion of the StudyBuddyGUI class**: Currently, the StudyBuddyGUI class does not center around a
single cohesive concept. For example, this class currently sets up the GUI window AND takes care of the button 
functionalities/response behaviours. Since these two tasks are clearly distinct from one another, it would be best to
separate them into two separate classes (one class would take care of the general set-up, and the other would take
care of the button functionalities). 
- **Including more helper functions**: Even though all my methods were less than 25 lines, I still think it would have
been better to use more helper functions, with each function aiming to achieve a single task that its name would
communicate to anyone reading my code. This way, even if someone who is not very familiar with my project was looking 
at my project, they would be able to read my code and follow its logic/purpose with the help of 
the descriptive helper functions.

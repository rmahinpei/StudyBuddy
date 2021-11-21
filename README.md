# StudyBuddy
*Taking time management to the next level*

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
- User adds a Topic to a Course: EventLog logs a new Event with the description "Added Topic: TOPIC NAME".
- User removes a Topic to a Course: EventLog logs a new Event with the description "Removed Topic: TOPIC NAME".
- User completes a question for a Topic of a Course: EventLog logs a new Event with the description 
"Completed a question for Topic: TOPIC NAME".

Here is a sample of what gets printed to the console after user quits StudyBuddy (assuming that they triggered
these events when they were using the application).
- *Added Topic: Abstraction*
- *Completed a question for Topic: Abstraction*
- *Removed Topic: Abstraction* 

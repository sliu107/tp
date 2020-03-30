# Developer Guide

## Design & Implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

### Design

#### Architecture

{Description of overall architecture}

#### Ui Component

The structure of the Ui Component is illustrated in the following diagram:

![UiComponentDiagram](images/UiComponent.png)

API : `Ui.java`

1. The `Ui` class is used to communicate with users.
2. The `Ui` class depends on `Scanner` to get inputs from users.
3. The `Main` class uses `Ui#getNextLine()` to receive `commands` from users.
4. And `FlashcardFactory` and `GroupFactory` classes uses methods in `Ui` class to complete 
the execution of various commands.

Given below is the Sequence Diagram for interactions between the `Ui` and `FlashcardFactory` components to complete the
execution of `deleteCommand`.

![UiSequenceDiagram](images/UiSequenceDiagram.png)

#### Parser Component

{Description for Parser Component}

#### Storage Component

{Description for Storage Component}

### Implementation

#### Set Priority Feature

The Set Priority feature allows users to mark a flashcard with a specified priority level. The priority level is
then reflected when the user requests a list of existing flashcards.

##### Proposed Implementation

`PriorityLevel` is stored as an enum with four fields: LOW, MEDIUM, HIGH and DEFAULT.

The feature implements the following operations:

- `Flashcard#setPriorityLevel()` - Sets a flashcard to a specified priority level (LOW/MEDIUM/HIGH).
- `Flashcard#getPriorityAsString()` - Return an icon indicating the flashcard's priority level.

The following class diagram shows the structures relevant to the Set Priority feature:

![SetPriorityFeatureClassDiagram](images/SetPriorityFeatureClassDiagram.png)

Given below is an example usage scenario and how the set priority mechanism behaves at each step.

Step 1. The user launches the application and creates a new `Flashcard` (of type Event, Person, or Other), 
with a default priority level of DEFAULT.

Step 2. The user executes `priority [flashcard index] [priority level]` command and the `setPriorityLevel` 
operation is invoked. Subsequently, the flashcard of specified index is retrieved from the main `FlashcardList` 
instance. Its priority level is set to the specified priority.

The following sequence diagram shows the relevant interactions behind `setPriorityLevel`:

![setPriorityLevelSequenceDiagram](images/setPriorityLevelSequenceDiagram.png)

#### Study Plan Feature

##### Proposed Implementation

The Study Plan feature is facilitated by `StudyPlanList`.

Internally, it implements a `TreeMap`, with date as key and the list of flashcard indexes to study as value. 
Key-value pairs in the `TreeMap` are sorted by dates.

It implements the following operations:

- `StudyPlanList#updateStudyPlan()` - Updates the study plan list.
- `StudyPlanList#getStudyPlanList()` - Gets the list of study plans.

Given below is an example usage scenario and how the study plan mechanism behaves at each step.

Step 1. The user launches the application and an empty `StudyPlanList` is initialized.

Step 2. The user executes `plan` command and the `updateStudyPlan` operation is invoked. The application prompts the
user for date and the corresponding list of flashcards indexes.

The following sequence diagram shows how the `updateStudyPlan` operation works:

![updateStudyPlanSequenceDiagram](images/updateStudyPlanSequenceDiagram.png)

Step 3. The user executes `show-plan` command and the `getStudyPlanList` operation is invoked. The application
displays the user's study plan list.

The following sequence diagram shows how the `getStudyPlanList` operation works:

![getStudyPlanListSequenceDiagram](images/getStudyPlanListSequenceDiagram.png)

#### Random Review Feature

##### Proposed Implementation

The random review mechanism is facilitated by `FlashcardList`.It stores an `List<Flashcard>` internally which contains
all the flashcards created by the user.

It implements the following operation:

- `FlashcardList#reviewRandomFlashcards()` -Randomize all the flashcards, then display the details of them one by one 
to the user. And update the review status of the flashcards corresponding to the user's' responses.

Given below is an example usage scenario and how the random review mechanism behaves at each step.

Step 1. The user launches the application for the first time. The `FlashcardsList` will be initialized with the empty 
flashcards list.

Step 2. The user executes `event/person/other commands` to add multiple flashcards to the flashcard list 
(The detailed implementation of creating flashcards explained in the Flashcard Creation Feature)

Step 3. The user executes `random command` and `reviewRandomFlashcards()` operation is invoked. The application prompts 
responses for each unreviewed flashcard that whether the user want to mark it as reviewed or not.

The following sequence diagram shows how the   `reviewRandomFlashcards()` operation works:

![randomReviewSequenceDiagram](images/randomReviewSequenceDiagram.png)

## Product Scope
### Target user profile

History Flashcard (HF) is for those who are studying history subjects to create flashcards which summarize 
the most important information for historical events, figures and artifacts. HF is optimized for those who 
prefer to use a simple Command Line Interface (CLI). 

### Value proposition

History is a subject that usually relies on heavy memorisation of a large amount of content. In order to 
make revision easier for history students, HF includes features that help with memory retention and organises 
information in a way that makes it convenient to review.

In HF, information can be entered in the form of flashcards with different fields, such as the name of the 
historical event/person, the relevant dates, and a summary. Flashcards can be categorised into user-defined groups
 to enable students to organise their knowledge better. Users can also create daily study plans.
 
 In addition, the user can shuffle and display random flashcards for revision.

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|student|add a Person flashcard|record the details about a historical figure|
|v1.0|student|add an Event flashcard|record the details about a historical event|
|v1.0|student|add an Other flashcard|record the details about any other historical item|
|v1.0|student|list all flashcards|get an overview of all my existing flashcards|
|v1.0|student|delete a flashcard|remove the flashcards that I no longer need|
|v1.0|student|view all the fields of a flashcard|review the details of a specific flashcard|
|v1.0|student|mark a flashcard as Reviewed|keep track of my learning progress|
|v1.0|student|assign priority to flashcards|identify the relative importance of flashcards for review|
|v1.0|student|view a timeline of all events and people|better organize my knowledge|
|v1.0|student|make groups for flashcards|group related flashcards together for more organized revision|
|v1.0|student|see all the commands available|find out what commands are available, and their format|
|v2.0|student|set a daily study plan|keep myself motivated to review flashcards every day|
|v2.0|student|list the flashcards which have been reviewed|keep track of my learning progress|
|v2.0|student|list all existing flashcard groups|view all the groups I have created|
|v2.0|student|list flashcards from a particular group|quickly identify the flashcards belonging to a group|
|v2.0|student|search for flashcards using a keyword|quickly find the flashcard I am looking for|
|v2.0|student|save flashcards to a storage file|flashcards are not lost when I exit the app|
|v2.0|student|read in flashcards from a storage file|flashcards can be loaded when I enter the app|
|v2.0|student|save my daily study plan to a storage file|study plans are not lost when I exit the app|
|v2.0|student|read in study plans from a storage file|study plans can be loaded when I enter the app|
|v2.0|student|save flashcard groups to a storage file|groups are not lost when I exit the app|
|v2.0|student|read in flashcard groups from a storage file|groups can be loaded when I enter the app|
|v2.0|student|restrict the timeline to a fixed period|keep track of flashcards belonging to a certain time period|
|v2.0|student|shuffle and display random flashcards|test my knowledge using random flashcards|
|v2.0|student|reset all the flashcards as unreviewed|review flashcards for multiple times

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for Manual Testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}

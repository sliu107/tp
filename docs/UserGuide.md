# History Flashcard - User Guide

1. [Introduction](#introduction)
2. [Quick Start](#quick-start)
3. [Features](#features)
    - [Command Format](#command-format)
    - [Basic](#basic)
    - [Flashcard Creation](#flashcard-creation)
    - [Flashcard Basic Operations](#flashcard-basic-operations)
    - [Flashcard Status Operations](#flashcard-status-operations)
    - [Flashcard Grouping](#flashcard-grouping)
    - [Study Plans](#study-plans)
    - [Randomized Review](#randomized-review)
4. [FAQ](#faq)
5. [Command Summary](#command-summary)

## 1. Introduction

History Flashcard (HF) is for those who are studying history subjects to create flashcards which summarize the most 
important information for historical events, figures and artifacts. HF is optimized for those who prefer to use a 
simple Command Line Interface (CLI). It includes features that help with memory retention and make information 
convenient to review, e.g. the ability to organize historical events into timelines and store bite-size details about history figures.

## 2. Quick Start

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `HistoryFlashcard` from [here](https://github.com/AY1920S2-CS2113-T14-1/tp/releases).
3. Move the JAR file to the folder you want to use as the home folder for `HistoryFlashcard `.
4. Double-click the file to start the application or run the command `java -jar [path-to-history-flashcard-jar-file]` from terminal
5. Type in commands and start using `HistoryFlashcard`!

## 3. Features 

### 3.1. Command Format
Words in `UPPER_CASE` are parameters to be supplied by the user.

Items in square brackets are optional e.g `TITLE [DETAILS]` can be used as `Title Some Detail` or just `Title`.

### 3.2. Basic
#### 3.2.1. Getting Help: `help`

Displays a list of commands available.

Format: `help`

#### 3.2.2. Exiting the program: `bye`

Exits History Flashcard.

Format: `bye`

### 3.3. Flashcard Creation
#### 3.3.1. Adding an Event Flashcard: `event`

Adds an Event Flashcard.

Format: `event`

The application will then prompt the user to enter the following fields:

- `EVENT_NAME`: can be in a natural language format
- `START_TIME`: has to be in valid date format
- `END_TIME`: has to be in valid date format
- `SUMMARY`: can be in a natural language format
- `DETAIL`: can be in a natural language format

There can be 0 or multiple `DETAIL`s added for an Event Flashcard. To stop entering details, just enter an empty line
by hitting `ENTER/RETURN`.

Example of usage:

```
event
Meiji Restoration
1868
1868
Turning point in Japanese history
End of Shogunate
Centralization of power
Functional end of Samurai Class

```

#### 3.3.2. Adding a Person Flashcard: `person`

Adds a Person Flashcard.

Format: `person` 

The application will then prompt the user to enter the following fields:

- `PERSON_NAME `: can be in a natural language format
- `BIRTH_DAY`: has to be in valid date format
- `DEATH_DAY`: has to be in valid date format
- `SUMMARY`: can be in a natural language format
- `DETAIL`: can be in a natural language format

There can be 0 or multiple `DETAIL`s added for a Person Flashcard. To stop entering details, just enter an empty line
by hitting `ENTER/RETURN`.

Example of usage:

```
Albus Dumbledore
Late August, 1881
08 1881
30/06/1997
Albus Dumbledore was never proud or vain.
He could find something to value in anyone, however apparently insignificant or wretched
Dumbledore became most famous for his defeat of Gellert Grindelwald, the discovery of the twelve uses of dragon's blood, and his work on alchemy with Nicolas Flamel

```

#### 3.3.3. Adding an Other Flashcard: `other`

Adds an Other Flashcard.

Format: `other`

The application will then prompt the user to enter the following fields:

- `NAME`: can be in a natural language format
- `SUMMARY`: can be in a natural language format
- `DETAIL`: can be in a natural language format

There can be 0 or multiple `DETAIL`s added for an Other Flashcard. To stop entering details, just enter an empty line
by hitting `ENTER/RETURN`.

Example of usage:

```
Resurrection Stone
The Resurrection Stone is one of the fabled Deathly Hallows.
In "The Tale of the Three Brothers", it was the second Hallow created, supposedly by Death himself
It was bestowed upon Cadmus Peverell after he requested, as his bounty, something with the power to recall loved ones from Death
According to legend, whoever reunited it with the other two Hallows (the Elder Wand and the Cloak of Invisibility) would become the Master of Death

```

### 3.4. Flashcard Basic Operations
#### 3.4.1. Listing All Flashcards: `list`

Lists all flashcards in the application.

Format: `list`

#### 3.4.2. Showing Timeline: `timeline`

List all flashcards in order sorted by start/birth date.
Specifying STARTDATE and ENDDATE will restrict the timeline to this period, inclusive of both dates.

Format: `timeline [STARTDATE] [ENDDATE]`

#### 3.4.3. Deleting a Flashcard: `delete`

Deletes the flashcard at the specified index in the list.

Format: `delete INDEX`

- The `INDEX` must be in a valid number format.

Example of usage:

`delete 3`

#### 3.4.4. Showing a Flashcard: `show`

Shows all fields from the flashcard at the specified index in the list.

Format: `show INDEX`

- The `INDEX` must be in a valid number format.

Example of usage:

`show 3`

#### 3.4.5. Finding Flashcards with Names Containing a specific keyword: `find`

Displays all flashcards with names containing the KEYWORD.

Format: `find KEYWORD`

### 3.5. Flashcard Status Operations
#### 3.5.1. Assigning Priority to a Flashcard: `priority`

Assign Priority Level `LOW`, `MEDIUM`, `HIGH` to the flashcard at the specified index.

Format: `priority INDEX PRIORITY_LEVEL`

- `INDEX`: must be in a valid number format
- `PRIORITY_LEVEL`: must be one of `LOW`, `MEDIUM`, `HIGH`, `DEFAULT`

Example of usage:

`priority 2 MEDIUM`

#### 3.5.2. Listing Flashcards of a Specified Priority: `list-priority`

Lists all flashcards which match the specified priority level.

Format: `list-priority PRIORITY_LEVEL`

- `PRIORITY_LEVEL`: must be one of `LOW`, `MEDIUM`, `HIGH`, `DEFAULT`

#### 3.5.3. Marking Flashcard as Reviewed: `reviewed`

Marks a flashcard at the specified index as reviewed.

Format: `reviewed INDEX`

- `INDEX`: must be in a valid number format

Example of usage:

`reviewed 1`

#### 3.5.4. Listing Reviewed Flashcards: `list-reviewed`

Lists all reviewed flashcards.

Format: `list-reviewed`

#### 3.5.5. Resetting Review status of Flashcards: `reset-reviewed`

Resets status of all flashcards to un-reviewed.

### 3.6. Flashcard Grouping
#### 3.6.1. Grouping Flashcards: `group`

Creates a new group of flashcards.

Format: `group`

The application will then prompt the user to enter the following fields:

- `NAME`: can be in a natural language format
- `DESCRIPTION`: can be in a natural language format
- `INDEXES`: a list of index numbers separated by space

Example of usage:

```
group
Harry Potter Flashcards
This is a group for HP related stuff.
2 3
```

#### 3.6.2. Adding Flashcard to Group: `add`

Adds a flashcard to a group.

Format: `add`

The application will then prompt the user to enter the following fields:

- `INDEX`: must be in a valid number format
- `GROUP_NAME`: can be in a natural language format

Example of usage:

```
add
1
Harry Potter Flashcards
```

#### 3.6.3. Displaying groups: `show-groups`

Lists all existing groups.

Format: `show-groups`

#### 3.6.4. Listing flashcards in a group: `list-group`

Lists all flashcards in a group specified by `GROUP_ID`.

-`GROUP_ID` can be the index of the group in the list generated by `show-groups`, or simply
the name of the group.

Format: `list-group GROUP_ID`

#### 3.6.5. Deleting flashcard group from the group list: `delete-group`

Deletes an existing group specified by `GROUP_ID` from the group list.

-`GROUP_ID` can be the index of the group in the list generated by `show-groups`, or simply
the name of the group.

Format: `delete-group GROUP_ID`

### 3.7. Study Plans
#### 3.7.1. Creating a new study plan: `plan`

Creates a new study plan by specifying date and indexes of existing flashcards.

Format: `plan`

The application will then prompt the user to enter the following fields:

- `DATE`: the date which the user want to set a study plan for
- `FLASHCARD_INDEXES`: indexes of the flashcards in the study plan

Example of usage:

```
plan
01/01/2020
1 3
```

#### 3.7.2. Displaying all study plans: `show-plan`

Lists all study plans.

Format: `show-plan`

#### 3.7.3. Deleting a study plan: `delete-plan`

Deletes a specified study plan. 
The user will be prompted to enter the date of the study plan they wish to delete.

Format: `delete-plan`

### 3.8. Randomized Review
#### 3.8.1. Displaying a random Flashcard: `random`

Shuffles and displays all the flashcards in a random order.

Format: `random`

The application will then prompt the user to give responses during the review:


Format:  
`yes` or `y` to mark the flashcard just shown as reviewed  
`no` or `n` to keep the flashcard just shown as unreviewed

## 4. FAQ

**Q**: How are the flashcards, flashcard groups, and study plans saved?

**A**: The application automatically saves these information in `JSON` format for you as you make changes to them. 
There is not a specific command to save these information to storage.

**Q**: Where are the flashcards, flashcard groups, and study plans saved?

**A**: They are saved under the `historyflashcards/` folder.

**Q**: Can I edit the storage files under the `historyflashcards/` folder?

**A**: Please avoid editing the files as changing the file format might cause reload from storage to fail when you
restart the application.

## 5. Command Summary

- Help: `help`
- Exit: `bye`
- Add event flashcard: `event`
- Add person flashcard: `person`
- Add other flashcard: `other`
- List all flashcards: `list`
- Show timeline: `timeline [STARTDATE] [ENDDATE]`
- Delete a flashcard: `delete INDEX`
- Show a flashcard: `show INDEX`
- Find a flashcard: `find KEYWORD`
- Creates a new group: `group`
- Adds a flashcard to a group: `add`
- List all groups: `show-groups`
- Delete a group: `delete-group GROUP_ID`
- List flashcards from a group: `list-group GROUP_ID`
- Assigns priority to a flashcard: `priority INDEX PRIORITY_LEVEL`
- List flashcards of a specified priority: `list-priority PRIORITY_LEVEL`
- Mark a flashcard as reviewed: `reviewed INDEX`
- List all reviewed flashcards: `list-reviewed`
- Reset all flashcards to unreviewed: `reset-reviewed`
- Create a study plan: `plan`
- List all study plans: `show-plan`
- Delete a study plan: `delete-plan`
- Start randomized review: `random`


# User Guide

## Introduction

History Flashcard (HF) is for those who are studying history subjects to create flashcards which summarize the most important information for historical events, figures and artifacts. HF is optimized for those who prefer to use a simple Command Line Interface (CLI). It includes features that help with memory retention and make information convenient to review, e.g. the ability to organize historical events into timelines and store summarized biographies of history figures.

## Quick Start

1. Ensure that you have Java 11 or above installed.
2. Down the latest version of `HistoryFlashcard` from [here](https://github.com/AY1920S2-CS2113-T14-1/tp/releases).
3. Move the JAR file to the folder you want to use as the home folder for `HistoryFlashcard `.
4. Double-click the file to start the application or run the command `java -jar [path-to-history-flashcard-jar-file]` from terminal
5. Type in commands and start using `HistoryFlashcard`!

## Features 

### Command Format
Words in `UPPER_CASE` are the parameters to be supplied by the user e.g. in `add other t/TITLE`, `TITLE` is a parameter which can be used as add t/Some Title.

Items in square brackets are optional e.g `t/TITLE [d/DETAILS]` can be used as `t/Some Title d/Some Details` or `t/Some Title`

Items with `...`​ after them can be used multiple times including zero times e.g. `[d/DETAILS]...​` can be omitted or used as `d/Detail 1 d/Detail 2`.

Parameters can be added in any order.

### Getting Help: `help`

Gets a list of command available for us.

Format: `help`

### Adding an Event Flashcard: `event`

Adds an Event Flashcard.

Format: `event`

The application will then prompt the user to enter the following fields:

- `EVENT_NAME`: can be in a natural language format
- `START_TIME`: has to be in valid date format
- `END_TIME`: has to be in valid date format
- `SUMMARY`: can be in a natural language format
- `DETAIL`: can be in a natural language format

There can be 0 or multiple `DETAIL` added for an Event Flashcard.

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

### Adding a Person Flashcard: `person`

Adds a Person Flashcard.

Format: `person` 

The application will then prompt the user to enter the following fields:

- `PERSON_NAME `: can be in a natural language format
- `BIRTH_DAY`: has to be in valid date format
- `DEATH_DAY`: has to be in valid date format
- `SUMMARY`: can be in a natural language format
- `DETAIL`: can be in a natural language format

There can be 0 or multiple `DETAIL` added for a Person Flashcard.

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

### Adding an Other Flashcard: `other`

Adds an Other Flashcard.

Format: `other`

The application will then prompt the user to enter the following fields:

- `NAME`: can be in a natural language format
- `SUMMARY`: can be in a natural language format
- `DETAIL`: can be in a natural language format

There can be 0 or multiple `DETAIL` added for a Person Flashcard.

Example of usage:

```
Resurrection Stone
The Resurrection Stone is one of the fabled Deathly Hallows.
In "The Tale of the Three Brothers", it was the second Hallow created, supposedly by Death himself
It was bestowed upon Cadmus Peverell after he requested, as his bounty, something with the power to recall loved ones from Death
According to legend, whoever reunited it with the other two Hallows (the Elder Wand and the Cloak of Invisibility) would become the Master of Death

```

### Listing All Flashcards: `list`

Lists all flashcards in the application.

Format: `list`

### Deleting a Flashcard: `delete`

Deletes the flashcard at the specified index in the list.

Format: `delete INDEX`

- The `INDEX` must be in a valid number format.

Example of usage:

`delete 3`

### Showing a Flashcard: `show`

Shows all fields from the flashcard at the specified index in the list.

Format: `show INDEX`

- The `INDEX` must be in a valid number format.

Example of usage:

`show 3`

### Showing Timeline: `timeline`

Shows the timeline of all events and people.

Format: `timeline`

### Grouping Flashcards: `group`

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

### Adding Flashcard to Group: `add`

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

### Assigning Priority to a Flashcard: `priority`

Assign Priority Level `LOW`, `MEDIUM`, `HIGH` to the flashcard at the specified index.

Format: `priority INDEX PRIORITY_LEVEL`

- `INDEX`: must be in a valid number format
- `PRIORITY_LEVEL`: must be one of `LOW`, `MEDIUM`, `HIGH`

Example of usage:

`priority 2 MEDIUM`

### Marking Flashcard as Reviewed: `reviewed`

Marks a flashcard at the specified index as reviewed.

Format: `reviewed INDEX`

- `INDEX`: must be in a valid number format

Example of usage:

`reviewed 1`

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: Well, write the User Guide in active voice anyway.

## Command Summary

- Help: `help`
- Add event flashcard: `event`
- Add person flashcard: `person`
- Add other flashcard: `other`
- List all flashcards: `list`
- Delete a flashcard: `delete INDEX`
- Show a flashcard: `show INDEX`
- Show timeline: `timeline`
- Creates a new group: `group`
- Adds a flashcard to a group: `add`
- Assigns priority to a flashcard: `priority INDEX PRIORITY_LEVEL`
- Mark a flashcard as reviewed: `reviewed INDEX`


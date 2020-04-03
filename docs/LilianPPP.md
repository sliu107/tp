# Guo Lilian - Project Portfolio
## PROJECT: History Flashcard

## Overview
History Flashcard (HF) is an app for history students to create flashcards which summarize the 
most important information for historical events, figures and artifacts. 
HF is optimized for those who prefer to use a simple Command Line Interface (CLI), and includes 
features that help with memory retention and make information convenient to review.

## Summary of Contributions
Find the code contributed 
[here](https://nus-cs2113-ay1920s2.github.io/tp-dashboard/#=undefined&search=g-lilian).

#### Features implemented
- Mark flashcards as reviewed
   - Function: Allows the user to input `reviewed [INDEX]` to change a flashcard's review
   status to reviewed.
   - Justification: It is important for users to be able to keep track of which flashcards
   they have already reviewed, so that they can better plan their revision.
   - Highlights: 
      - This feature involved adding another variable to the abstract `Flashcard` 
       class to keep track of each flashcard's review status.
      - Other classes like `Ui` were also modified to display the review status alongside
       the flashcard name/descriptions.
- Assign priority to flashcards
   - Function: Allows the user to input `priority [INDEX] [PRIORITY LEVEL]` to assign a 
   flashcard's priority level.
   - Justification: Knowing the relative importance of a flashcard helps users decide 
   on which flashcards to review first, thus helping them to better plan their revision.
   - Highlights:
      - This feature involved adding another variable to the abstract `Flashcard` 
       class to keep track of each flashcard's priority level.
      - Other classes like `Ui` were also modified to display the priority level alongside
       the flashcard name/descriptions.
      - An enum was created for priority level to restrict the input argument to 
       `LOW`, `MEDIUM`, `HIGH`, or `DEFAULT`. The implementation was complicated by the need 
       to handle exceptions for incorrect input format.
- Show the details of a flashcard
   - Function: Allows the user to input `show [INDEX]` to display all fields of a flashcard.
   - Justification: Users can type `list` to see an overview of all the flashcards they have 
   created. The `show` command is for users to review the specific details of a flashcard.
- List all existing groups
   - Function: Allows the user to input `show-groups` to display all existing groups.
   - Justification: This feature complements the `group` feature implemented by Shiyue. After 
   creating flashcard groups, users should be able to view all existing groups.
- List flashcards from a specific group
   - Function: Allows the user to input `list-group [INDEX/GROUPNAME]` to display all flashcards 
   belonging to a group.
   - Justification: This feature complements the `group` feature implemented by Shiyue. After 
   creating flashcard groups, users should be able to list the flashcards present in a group.
   - Highlights:
      - This implementation was complicated by the option to list based on either group name or 
      the group's index in the group list. In `GroupList`, the code first checks if the argument 
      is a group name. If not, it checks if it is a valid group index. If the argument is invalid, 
      an exception is thrown.
- List restricted timeline
   - Function: Allows the user to input `timeline [STARTDATE] [ENDDATE]` to display a sorted 
   list of existing flashcards belonging to a restricted period of time.
   - Justification: If users wish to study only flashcards belonging to a particular 
   historical period, they can easily identify those flashcards for review.
   - Highlights: 
      - This feature required modification of the existing `TimelineCommand`.
      - Additional considerations were required for `STARTDATE` and `ENDDATE` to be included as 
      optional parameters without affecting the function of `timeline` when inputted as a 
      standalone command.

#### Other contributions
- Project management
   - Helped maintain the issue tracker
- General code enhancement
   - Edited Ui messages for various commands (e.g. `help`, `show-plan`, `plan`) to be more precise
- Documentation
   - Added user stories for v2.0 and product scope to the DG
   - Revised the command formats in the UG
- Community
   - PRs reviewed (with non-trivial review comments): 
   [#166](https://github.com/AY1920S2-CS2113-T14-1/tp/pull/166) 
   [#134](https://github.com/AY1920S2-CS2113-T14-1/tp/pull/134) 
   [#121](https://github.com/AY1920S2-CS2113-T14-1/tp/pull/121) 
   [#94](https://github.com/AY1920S2-CS2113-T14-1/tp/pull/94)
   - Forum discussions: 
   [#69](https://github.com/nus-cs2113-AY1920S2/forum/issues/69) 
   [#70](https://github.com/nus-cs2113-AY1920S2/forum/issues/70)

## Contributions to the User Guide

## Contributions to the Developer Guide
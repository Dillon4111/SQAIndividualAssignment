# SQAIndividualAssignment

## Sprint Backlog

| Task        | Point Estimation      | Owner     |
| :---        |    :----:   |          ---: |
| Investigate best code coverage tool      | 0       | Dillon Rochford   |
| Create POJOs   | 1        | Dillon Rochford      |
| Create Controller class that implements atleast 1 POJO   | 1        | Dillon Rochford      |
| Implement methods for creating and viewing objects   | 2        | Dillon Rochford      |
| Implement methods for calculations   | 2        | Dillon Rochford      |

<br />

For creating each task for the Sprint backlog, there were many decisions to be made. There is an importance to correclty breaking down the tasks so that there is enough work in each. I didn't feel that there was a need to add unit testing to the tasks as every implementation task should involve testing. The decision on how many points for tasks came from how many hours I estimated each task will take. This is a good way of planning the work and when to do it. For example, creating POJOs will take less time than implementing methods as it is mostly just generating getters and setters for variables. Implementing actual computational methods involves more thinking and time. 
The Velocity metric is a great way for a team to manage their work and plan for future sprints. A sprint velocity is the number of story points a team estimates they can complete in a single sprint. At the end of each sprint, the completed story points are totalled which then feeds into the planning for the future.

<br />

## Unit Testing and Test-Driven Development
Before finalising any piece of functional code, it is always important to test it repeatedly and thoroughly to make sure everything is running perfectly. This is where test-driven development (TDD) comes from. One of the main concepts of TDD is that the developer must first write a failing test before they begin to implement the functionality. This means that the developer sticks to their primary goal of what they want to achieve while also creating clean and simple code.
<br />
[This commit](https://github.com/Dillon4111/SQAIndividualAssignment/commit/b72f84265a32d0f063ec44e420fd4147d2647a01) is an example of writing JUnit tests for functional code. Each method that calulates a specific value, such as the average and standard deviation of a set of scores, was tested repeatedly with several sets of inputs. For testing these inputs I first calculated what the correct answer would be, and then worked towards that goal. Using these tests not only reassured me that my code was correct, it also helped me work faster and more effeciently as I did not have to run the actual controller to test these functions.


## Test Coverage Metric
A code coverage tool can play an important part in testing as it measures the amount of code being executed while the tests are running. It is a very good way of letting the developer know if they need to write more tests. The code coverage tool that was used for this assignment was Intellij's built-in one. It can be run by simply right-clicking on the test suite and running it with code coverage. This is what the tool looks like when it runs:

[![code-Coverage.png](https://i.postimg.cc/CK3rQw9R/code-Coverage.png)](https://postimg.cc/94BB4Hm2)

After noticing that my code coverage was only 9% for the controller, which does a lot of functionality, I realised that I needed to add more unit tests. When I added more I saw an increase of 12% of code coverage which is over double of what I had previously. The tests also cover twice the amount of methods as well:

[![code-Coverage2.png](https://i.postimg.cc/0QHjsHdK/code-Coverage2.png)](https://postimg.cc/ZBp4PHQJ)


## Team Version-Control
GitFlow is a branching model that helps dictate what kinds of branches to set up and how they are merged. I used this workflow by delegating the sprint tasks into separate branches. Instead of having just a singular branch, I created a main and a develop branch. Each feature branch is then branched from develop and when that task is completed it is then merged back into develop. These multiple feature branches allow for a more effecient way of collaboration as each developer could have their own branch and wouldn't have to worry about code conflicts until they have to merge.

[![branches.png](https://i.postimg.cc/NM4T75Zq/branches.png)](https://postimg.cc/YGvhtqpb)


## Code Reviews
A code review is a way of allowing other developers in your team to look through your code and make sure it is up to standard with their rules and guidelines. After a developer implements functionality and creates a pull request, the peers doing the code review may go through a checklist of things to make sure everything is perfect. This is an example of a code review checklist:

- ### Reusability - Considering reusable services, functions and components
- ### Maintainablitiy - Planning for the future
- ### Test Coverage - Make sure the code is tested well
- ### Security - See if they can spot any security problems
- ### Performance - How quickly your code can run for the user

In [this pull request](https://github.com/Dillon4111/SQAIndividualAssignment/pull/3), I went through the checklist and noticed that there was a lack of test coverage. Upon further inspection I realised that there was no real need for tests in this situation and made a comment in the pull request to make a note of it.

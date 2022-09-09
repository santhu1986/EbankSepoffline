Feature: Role Creation

Scenario Outline: Role creation with Multiple Sets of Data

Given Tester Should on Ranford Homepage

When Tester Enters Username password click on Login

Then Tester click on Role button

When Tester click on NewRole and enter "<RoleName>" and "<RoleType>"

Then Tester Close Application


Examples:
 
                       | RoleName | RoleType |
                       | Teller | E |
                       | Cashierfgh | E |
                       | Clerkdfg | E |
 
@Smoke
Feature: create lead

Scenario Outline:create lead positive
Given enter username as DemoSalesManager
And enter password as crmsfa
And click login button
When click crmsfa
And click leadslink
And click createLeadlink
And enter the company name as <cName>
And enter the First Name as <fName>
And enter the Last Name as <lName>
And click on the createLead button
Then verify the lead is created as <fName>

Examples:
|cName|fName|lName|
|vaishcmpny|vaish|kumar|
#|vaishcmpny1|vaish1|kumar1|

@Sanity
Scenario Outline:create lead positive
Given enter username as DemoSalesManager
And enter password as crmsfa
And click login button
When click crmsfa
And click leadslink
And click createLeadlink
And enter the company name as <cName>
And enter the First Name as <fName>
And enter the Last Name as <lName>
And click on the createLead button
Then verify the lead is created as <fName>

Examples:
|cName|fName|lName|
|vaishcmpny|vaish|kumar|
#|vaishcmpny1|vaish1|kumar1|
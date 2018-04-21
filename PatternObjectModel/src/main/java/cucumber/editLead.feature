Feature: edit lead

Scenario Outline:edit lead positive
Given enter username as DemoSalesManager
And enter password as crmsfa
And click login button
When click crmsfa
And click leadslink
And click findLeadlink
And enter the lead id as <leadId>
And click find leads button
And click resulting lead link
And click on edit lead button
And enter the company name to change as <changecmp>
Then click update
Examples:
|leadId|changecmp|
|123|vaish|
|100|vaish1|
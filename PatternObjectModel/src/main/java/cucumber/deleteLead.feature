Feature: delete lead
@delete
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
And click on delete lead button
And click findLeadlink
And enter the lead id as <leadId>
And click find leads button
Then validate No Records Found Message
Examples:
|leadId|
|10579|

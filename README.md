Java Back End Engineer Assignment
There are two parts to this Assignment, where the second part is an optional bonus. Please
read over the entire assignment and check the Additional Information section before starting.
Keep in mind that there are no ‘right answers.’ This assignment is designed to gauge your skills
and give us an idea of how you approach tasks relevant to the Java Back End Engineer role.

The Problem
Localcoin has ATM machines deployed in multiple locations around Canada. There are
scheduled cash pickups for every of them. The scheduled pick ups are manually assigned and
the date is recorded for each of them in an Excel Sheet. When the pick up is actually performed
the date is also recorded to be matched later with the associated scheduled date and ATM. As
an example we can describe the schedule and actual pick up in the Excel Sheet below:

Table 1: Example of schedule pickup data

atm_identifier expected_pickup actual_pickup
ATM1 2019-03-10
ATM1 2019-03-15
ATM1 2019-04-21 2019-04-23
ATM1 2019-04-26
ATM1 2019-05-15
ATM1 2019-05-17 2019-05-17
ATM2 2019-02-20
ATM2 2019-03-13 2019-03-13
ATM2 2019-05-10
ATM2 2019-05-15
ATM2 2019-05-16 2019-05-16
ATM2 2019-05-20
ATM2 2019-05-21
ATM2 2019-05-23 2019-05-23

In Table 1: example of schedule pickup data, some entries have no actual_pickup pair, which
means it is implicitly associated with the next actual_pickup which happened on a later date for
the same ATM. For example, the actual pickup date for 2019-03-10, 2019-03-15 and
2019-04-21 dates is 2019-04-23 for ATM1 in the same way the actual pickup date for
2019-04-26, 2019-05-15 and 2019-05-17 dates is 2019-05-17 for ATM1.

Based on the cash pick up sheet described on Table 1:
Create a RESTFul endpoint to return all the date ranges covered by each non-null
actual_pickup in the database using the prerequisites constraints and request/response
structures below:
Prerequisite constraints
- Your endpoint should use Spring Controller/Service/Repository layers
- Your endpoint should use the table already JPA mapped in the template project
- Your Repository layer should use only a single native SQL query to retrieve all the date
  ranges which each non-null actual_pickup covers. For the sample data in the Table 1
  your sql resultset in the repository layer would return:
  atm start_date end_date
  ATM1 2019-03-10 2019-04-23

HTTP Request sample:
curl -v --location --request GET 'http://localhost:7775/api/v1/search_ranges'
HTTP Response sample:
HTTP/1.1 200 OK
Content-Type: application/json;
[
{
"atm":"ATM1",
"ranges":[
{
"start_date":"2019-03-10",
"end_date":"2019-04-23"
},
{
"start_date":"2019-04-26",
"end_date":"2019-05-17"
}
]
},
{
"atm":"ATM2",
"ranges":[
{
"start_date":"2019-02-20",
"end_date":"2019-03-13"
},
{
"start_date":"2019-05-10",
"end_date":"2019-05-16"
},
{
"start_date":"2019-05-20",
"end_date":"2019-05-23"
}
]
}
]
ATM1 2019-04-26 2019-05-17
ATM2 2019-02-20 2019-03-13
ATM2 2019-05-10 2019-05-16
ATM2 2019-05-20 2019-05-23

Assignment Part 2
This is an optional bonus assignment and is not required. This gives us more insights on tasks
relevant to the Java Back End Engineer role. This does not affect your submission if not
completed as this is optional.
For assignment part 2, create a Unit Test case for the above assignment part 1 that you have
completed.
Additional Information
● The code should be developed under Java8 SDK and maven 3.6. Feel free to use any
IDE of your choice.
● The template project automatically creates the table you`ll need and it feeds the H2
database every time your application restarts with the contents of Table 1. Do not
modify the src/main/resources/data.sql file or create/change new tables.
● Make sure your final artifact is spring-boot runnable. We will run your code using the
command maven below in the root the path:
■ mvn spring-boot:run
● Make sure your endpoint is available in the port 7775 and with the same context root
paths denoted in the request samples
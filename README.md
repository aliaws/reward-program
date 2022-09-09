# Reward Program - API

### V4 JSON endpoints

| Link to API                                                              | Description                                          |
|--------------------------------------------------------------------------|------------------------------------------------------|
| <http://localhost:8080/transactions/monthly-total>                       | Monthly Total for All customers                      |
| <http://localhost:8080/transactions/monthly-total/customer={customerId}> | Get Monthly Total for a customer by id               |
| <http://localhost:8080/transactions/quarter-month={monthNumber}>         | Three months total for customers starting from month |
| <http://localhost:8080/customers/page={pageNumber}>                      | Three months total for customers starting from month |

**Note**: Please consider using the above endpoints for all your data needs. All the data we show on the website is fuelled by the above endpoints.

## Description

**EndPoints**: 
- transactions
  - monthly-total 
    - It is a GET request that returns monthly total for all customer in calendar year 2016 and returns an Array of JSON objects that includes 
    
        | columnName   | dataType |
        |--------------|----------|
        | customerId   | Integer  |
        | customerName | String   |
        | salesAmount  | Float    |
        | rewardPoints | Float    |
        | month        | String   |
        | year         | Integer  |

  - monthly-total/customer={customerId}
    - It is a GET request that returns monthly total for a single customer by id in the calendar year 2016 and returns an Array of JSON objects that includes

      | columnName   | dataType |
      |--------------|----------|
      | customerId   | Integer  |
      | customerName | String   |
      | salesAmount  | Float    |
      | rewardPoints | Float    |
      | month        | String   |
      | year         | Integer  |

  - quarter-month
    - It is a GET request that returns 3 months total for all customer by id in the calendar year 2016 and returns an Array of JSON objects that includes

      | columnName   | dataType |
      |--------------|----------|
      | customerId   | Integer  |
      | customerName | String   |
      | salesAmount  | Float    |
      | rewardPoints | Float    |
      | month        | String   |
      | year         | Integer  |
- customers 
  - page={pageNumber}
    - this endpoint retrieves the list of customers with pagination.

      | columnName | dataType   |
      |------------|------------|
      | id         | Integer    |
      | name       | String     |


- [Documentation](https://api.covid19india.org/documentation)

<img src="/home/syed/Pictures/Screenshots/Screenshot from 2022-09-09 15-30-47.png"/>
<img src="/home/syed/Pictures/Screenshots/Screenshot from 2022-09-09 15-31-08.png"/>
....................................................
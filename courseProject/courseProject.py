# Alfredo Perez
# December 13, 2019
# Program Overview: This program has 6 different features as outlined in the assignment sheet provided by Professor Ma.
# Method 1 displays the total number of closures for a city specified by the user input.
# Method 2 displays the banks that were foreclosed in a specified city by the user input.
# Method 3 displays the top 5 cities with the most closures
# Method 4 displays the total number of closures for a specified state at a specified year, based on user input
# Method 5 gets the 5 most recent closures
# Method 6 Displays the year that has the most closures
# The data is read from a csv file and manipulated through the methods.

#Import modules
import csv
import collections
from collections import Counter
from datetime import datetime
import datetime

#Read the CSV file and set them into selected variables
file = open("./banklist.csv")
reader = csv.reader(file)

header = next(reader)
print("The header of this CSV file are as follows:")
print(header)

# List comprehension
data = [row for row in reader]

file.close()

print("There are {} of rows.".format(len(data)))
print("The first row is: ", data[0])
print("The last row is: ", data[-1])

#Column 1: Bank Name [0]
#Column 2: City [1]
#Column 3: State [2]
#Column 4: CERT [3]
#Column 5: Acquiring Institution [4]
#Column 6: Closing Date [5]
#Column 7: Updated Date [6]


#Making Menu
# Welcome to the analysis tool for bank closures
# Your options for commands are:
# 1: Get the number of closures for a specified city
# 2: Get the banks of closures for a specified city
# 3: Get the top 5 cities with most closures
# 4: Get the number of closures for a specified state for a specified year
# 5: Get 5 most recent closures
# 6: Displays the year that has the most closures
# Exit: Exit the program


def menu():
  print("Menu \n1: Get the number of closures for a specified city \n2: Get the banks of closures for a specified city\n3: Get the top 5 cities with most closures\n4: Get the number of closures for a specified state for a specified year\n5: Get 5 most recent closures\n6. Display the year that has the most closures\n7: Exit the program")
  bool = True
  while bool == True:
    user_input = int(input("Input your choice of 1-7 from the menu: "))
    if user_input >= 1 and user_input <= 6:
      if user_input == 1:
        what_city = input("What city are you interested in?")
        closures(data, what_city)
      elif user_input == 2:
        what_city = input("What city are you interested in?")
        closures_in_city(data,what_city)
      elif user_input == 3:
        most_closures(data)
      elif user_input == 4:
        what_state = input("What state are you interested in? (Abbreviated)")
        what_year = int(input("what year are you interested in?"))
        closures_by_year(data, what_state, what_year)
      elif user_input == 5:
        recent_closures(data)
      elif user_input == 6:
        most_closures_by_year(data)
      elif user_input == 7:
        break
    else:
      break

# 1. Display the total number of closures for a specified city
# Closures: All banks in list are closed. Count the number of times a specified city is in the list.
def closures(data, what_city):
  counter = 0
  for i in range(len(data)):
    if what_city == data[i][1]:
      counter += 1
  print("In the city of {} there were {} closures".format(what_city,counter))

# 2: Get the banks of closures for a specified city
def closures_in_city(data,what_city):
  print("Closed banks in {} are:".format(what_city))
  for i in range(len(data)):
    if what_city == data[i][1]:
      print(data[i][0])

# 3: Get the top 5 cities with most closures
def most_closures(data):
  closure_dict = {}
  print("The 5 cities with the most foreclosures are")
  for i in range(len(data)):
    if data[i][1] not in closure_dict:
      closure_dict[data[i][1]] = 1
    else:
      closure_dict[data[i][1]] += 1
  c = collections.Counter(closure_dict)
  d = [k for k, v in c.most_common(5)]
  for i in range(len(d)):
    print(d[i])


# 4: Display the total number of closures for a specified state at a specified year (based on the year listed
# in the Closing Date)
def closures_by_year(data, what_state, what_year):
  count = 0
  for i in range(len(data)):
    date = datetime.datetime.strptime(data[i][5], "%d-%b-%y")
    year = date.year
    if what_state == data[i][2] and what_year == year:
      # print("In the state of {} in the year of {} there were {} closures".format(what_state, year, count))
      count += 1
  print("In the state of {} in the year of {} there were {} closures".format(what_state, year, count))

  # 5: Get 5 most recent closures (Based on Closing Date)
def recent_closures(data):
  recent_closed = []
  sortedList = sorted(data, key=lambda row: datetime.datetime.strptime(row[5], "%d-%b-%y"))
  for i in range(5):
    recent_closed.append(sortedList[i][0])
  print("The 5 most recent Bank Closures are:")
  for i in range(len(recent_closed)):
    print(recent_closed[i])

# 6. (Optional) Display the year that has the most closures (based on the year listed in the Closing Date)
def most_closures_by_year(data):
  closure_years = []
  for i in range(len(data)):
    date = datetime.datetime.strptime(data[i][5], "%d-%b-%y")
    closure_years.append(date.year)
  c = Counter(closure_years)
  print("The year with the most closures is {} with {} closures".format(c.most_common(1)[0][0], c.most_common(1)[0][1]))

def main():
  menu()

if __name__ == "__main__":
  main()


#Sample for Method 1:
# What city are you interested in? Newark
# In the city of Newark there were 2 closures.

#Sample output for Method 2:
# What city are you interested in?Newark
# Closed banks in Newark are:
# City National Bank of New Jersey
# Dollar Savings Bank

#Sample output for Method 3:
# The 5 cities with the most foreclosures are
# Chicago
# Atlanta
# Phoenix
# Naples
# Scottsdale

#Sample output for Method 4:
# What state are you interested in? (Abbreviated)TX
# what year are you interested in?2008
# In the state of TX in the year of 2000 there were 2 closures

#Sample output for Method 5
# The 5 most recent Bank Closures are:
# Bank of Honolulu
# National State Bank of Metropolis
# First Alliance Bank & Trust Co.
# Malta National Bank
# Superior Bank, FSB

#Sample output for Method 6
# The year with the most closures is 2010 with 157 closures

#Sample ouptput for Method 7
# Breaks
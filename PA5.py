#Alfredo Perez
#October 23, 2019
#Intro to Python for Data Analysis
#Program Overview: Creates 36 random scores from 1 - 100. I calculate
#minimum, maximum, and average from the random created numbers.
#Program finds the number of grades within certain ranges.
# i.e. 1-9, 1-11, etc. Then the program plots the range counts
#into a score distribution bar chart. Later it displays the statistical
#information in the form of a cumulative grade percentage in the console.

import matplotlib.pyplot as plt
import random

scores = []
range_counts = [0] * 11
sum = 0
min = 100
max = 0
avg = 0

#Create a list of 36 randomly generarted numbers
for i in range(36):
  scores.append(random.randint(0,100))

#Find Min, Max, and Avg
for j in scores:
    if j > max:
      max = j
    if j < min:
      min = j
    sum += j
    avg = sum / len(scores)

#Output the list of 36 scores
print("SCORE LIST: {}".format(scores))
#Output the Min
print("MIN: {}".format(min))
#Output the Max
print("MAX: {}".format(max))
#Output the Average
print("AVG: {}".format(round(avg, 2)))

#Floor each score by 10, If its 1 in range_counts[0], if 2 in range_counts[1], etc.

#If the value is 1, index 1 is increased. If value is 2, index 2 is increased.

#Go through each index of range_counts, if the scores floor divided by 10 are equal to that index,
#then the value of the index is increased by 1.


for m in range(len(range_counts)):
  for k in scores:
    if k // 10 == m:
      range_counts[m] += 1
print("RANGE COUNT: {}".format(range_counts))

# for index in range(len(scores)):
#   range_counts[scores[index]//10] += 1

print("_______________________________________________")

#Percentage is range_count value divided by total students (36)
#Iterate through the 10 different ranges, decreasing by 10 and recalculating
#the percentage of the next.
perc = 0
decreasing_cum = 110
for n in range(10, -1, -1):
  perc += (range_counts[n]/36)*100
  decreasing_cum -= 10
  print("{:<5}% of students made at least {}.".format(round(perc, 2), n*10))

#Creating the bar chart
heights = [0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
plt.xlabel('Score Ranges')
plt.ylabel('No. Of Students')
plt.title("Score Distribution")
plt.xticks([0,10,20,30,40,50,60,70,80,90,100], ['0-9', '10-19', '20-29', '30-39','40-49','50-59', '60-69', '70-79', '80-89', '90-99', '100+'])
bar_width = 5
# Build the bar chart.
plt.bar(heights, range_counts,bar_width, color="red")
# Display the bar chart.
plt.show()

#Bar chart is displayed with same names/titles as the one on the assignement.
#The console outputs something like
# 0.0  % of students made at least 100.
# 11.11% of students made at least 90.
# 16.67% of students made at least 80.
# 25.0 % of students made at least 70.
# 33.33% of students made at least 60.
# 50.0 % of students made at least 50.
# 58.33% of students made at least 40.
# 69.44% of students made at least 30.
# 72.22% of students made at least 20.
# 88.89% of students made at least 10.
# 100.0% of students made at least 0.

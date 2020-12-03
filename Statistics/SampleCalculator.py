import math

#A small program made to take a txt file called "nums" and take
#the data within and find average, min, max, stnd dev, variance,
#sample size, and sum.

file = open("nums", "r")
sum = 0
count = 0
valuesArr = []

for i in file:
  valuesArr.append(i)
  sum += float(i)
  count += 1

average = sum/count
minimum = min(valuesArr)
maximum = max(valuesArr)

devSum = 0
file.seek(0)
for i in file:
  devSum += pow((float(i)-average),2)

#Variance
devSum = (devSum * 1) / (count - 1)
variance = devSum

#Square root of variance to get Standard Deviation
devSum = math.sqrt(devSum)

print("Average:",str(round(average, 3)))
print("Maximum:",str(maximum).strip("\n"))
print("Minimum:",str(minimum).strip("\n"))
print("Standard Deviation:",str(round(devSum,4)))
print("Variance:",str(round(variance,4)))
print("Sample Size:",str(count))
print("Sum:",str(round(sum,2)))


file.close()

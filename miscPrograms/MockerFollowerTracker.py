import random

#An interview question sample that simulates
#a user's follower count over a 24 hour period
#

class userStats:

  def __init__(self, username):
    self.username = username
    self.followerList = []
    for i in range(24):
      self.followerList.append(0)

  def update(self, hour, value):
    self.followerList[hour-1] += value

  def query(self, start, end):
    sum = 0
    for i in range(start-1, end):
      sum+= self.followerList[i]
    return sum

#Simulating a user, JohnDo3, who gained between 0
#and 3 followers every hour over the span of 24 hours
user1 = userStats("JohnDo3")
for i in range(0, 24):
  temp = random.randint(0,3)
  print("Hour "+str(i+1)+":" +str(temp))
  user1.update(i, temp)

print(str(user1.username)+" gained " +str(user1.query(1,24))+" new followers today!")

print("\t"+str(user1.query(1,12))+" of which were gained between 1 and 12 hours")

print("\t"+str(user1.query(13,24))+" of which were gained between 13 and 24 hours")

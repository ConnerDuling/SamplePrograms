import heapq
import math

class Point:
  def __init__(self, xPoint, yPoint):
    self.xPoint = xPoint
    self.yPoint = yPoint

  def __lt__(self, other):
    return self.xPoint + self.yPoint < other.xPoint + other.yPoint

  def getPointString(self):
    return str(self.xPoint)+", "+str(self.yPoint)

def getKNearestPoints(k, pointList, cP):
  if k > len(pointList):
    return -1
  
  h = []
  for i in pointList:
    calcDist = math.sqrt(pow(i.xPoint-cP.xPoint, 2)+pow(i.yPoint-cP.yPoint, 2))
    heapq.heappush(h, (calcDist, i))

  l = []
  for i in range(k):
    l.append(heapq.heappop(h))

  return l


centerPoint = Point(-1,5)
points = []
dimensions = 5

xs = list(range(1,10+1))
for i in xs:
  for j in xs:
    points.append(Point(i,j))

nearestPoints = getKNearestPoints(5, points, centerPoint)

if nearestPoints == -1:
  print("Error. Too many points specified for number of given points.")
else:
  for i in (nearestPoints):
    print(i[1].getPointString())


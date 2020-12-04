import re
import random


def dice_roll(dieValue):
    return random.randint(1, dieValue)


def dice_pool(groups, dice, dicevalue):
    for i in range(groups):
        tempList = []
        sum = 0
        for j in range(dice):
            roll = dice_roll(dicevalue)
            sum += roll
            tempList.append(roll)
        print(str(tempList) + " = "+str(sum))


word = input("Enter input: ")

listw = re.split('d| ', word)

if(len(listw) == 3):
    dice_pool(int(listw[0]), int(listw[1]), int(listw[2]))
elif(len(listw) == 2):
    dice_pool(1, int(listw[0]), int(listw[1]))

keyToFind = 379
keys = [3,7,8,14,83,119,120,348,361,379,422,501,843,992]

def search(keys, key):
	print(("Searching for: " + str(key)))
	print(("In an array with these values: " + str(keys)))
	print("")
	size = len(keys)
	left = 0
	right = size - 1
	count = 1
	while(left <= right):
		middle = left + (right-left)//2
		
		print(("Round of searching: " + str(count)))
		print(("Leftmost Value: " + str(left)))
		print(("Rightmost Value: " + str(right)))
		print(("Middle Value: " + str(middle)))
		print(("Current middle: " + str(keys[middle])))

		if (keys[middle]==key):
			print("")
			print("Found the value we are looking for")
			print(("It was located at: " + str(middle)))
			return middle

		if (keys[middle] < key):
			left = middle+1
			print("Value we are looking for is higher than the current middle")
		else:
			right = middle-1
			print("Value we are looking for is lower than the current middle")
		count = count + 1
		print("")

keys = [3,7,8,14,83,119,120,348,361,379,422,501,843,992]

print(search(keys, keyToFind))

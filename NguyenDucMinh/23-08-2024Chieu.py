def longer(stringA, stringB):
	print('length a = '+str(len(stringA)))	
	print('length b = '+str(len(stringB)))
	return len(stringA) > len(stringB)

a = "Helen"
b = "Hahahaha"

#print('Result: ')	
#print(longer(a, b))
#Viet chuong trinh nhap 2 so tu ban phim va tinh tong

'''
x = int(input('Enter x = '))
y = int(input('Enter y = '))
sum = x + y
print('Sum x and y is : '+str(sum))
'''

#Ham eval = evaluate = tinh gia tri cua 1 bieu thuc duoi dang string
'''
print("3*(2+3)")
print(eval("3*(2+3)"))
'''
#Nhap diem hoc sinh tu ban phim
#Neu diem >= 5 : hien ra pass
#neu diem < 5 : failed

'''
mark = int(input('enter your mark: '))
if(mark >= 5):
	print('passed')
else:
	print('failed')
'''

#Nhap diem hoc sinh tu ban phim
#Neu diem tu 8 den 10 : A
#Neu diem tu 5 den 7 : B
#Neu diem < 5 : C
#Neu diem < 0 hoac > 10 : Invalid

'''
mark = int(input('enter your mark: '))
if(mark >= 8 and mark <= 10):
	print('A')
elif(mark >= 5 and mark <= 7):
	print('B')
elif(mark < 5 and mark >= 0):
	print('C')
else:
	print('Invalid')

'''

'''
#assign gia tri so gio lam viec trong tuan va tien
hours_worked = 41
pay_rate = 5 #5 dollars per hour

salary = hours_worked * pay_rate
print('Your salary is : '+str(salary))

#overtime_pay = 0
if(hours_worked > 40):
	overtime = hours_worked - 40
	overtime_pay = overtime * pay_rate * 0.5

salary = salary + overtime_pay
print('Your salary(after overtime) is : '+str(salary)) 	
'''

'''
#In cac so tu 1 den 20(cach 1)
for x in range(20):
	#print(x+1)
	#chi hien so chan tu 1 den 100	
	if ((x + 1) % 2 == 0):
		print(x+1)	
'''
#In cac so tu 1 den 20(cach 2)
'''
for x in range(1, 21):
	print(x)
'''

#In cac so tu 1 den 100, hien so du khi chia 2
'''
for x in range(100):
	remains = (x + 1) % 2
	print('number is '+str(x + 1) +', remains : '+str(remains))

'''

'''
#Tam tac dung cua bien toan cuc (global variable) la trong file python do
def functionA():
	global x1
	x1 = 100
	print(x1)

functionA()
print(x1)
'''

'''
#tinh tong cac so tu 1 den 10
sum_from_1_to_n = 0
for i in range(10):
	#sum_from_1_to_n = sum_from_1_to_n + (i + 1)
	sum_from_1_to_n += (i + 1)

print('result is '+str(sum_from_1_to_n))
'''


#Duyet ky tu trong 1 chuoi
#Iterate each character inside a string
#Iterate each letter inside a word
'''
name = 'Hoang'
for each_character in name:
	print(each_character)
'''

#Duyet tung phan tu trong 1 mang(list)
#Iterate each item in an array/list
'''
names = ['Hoang', 'John', 'Anna', 'Peter']
for name in names:
	#only print name which length >= 5
	if(len(name) >= 5):
		print(name)
'''
#hay in cac so tu 20 ve 1 

'''
start = 20
while start > 0:
	print(start)
	#start = start - 1	
	start -= 1
'''

#infinite loop(loop forever)
'''
start = 10
while start > 0:
	#start = start * 2
	print(start)
'''

'''
lines = open('./abc.txt')
for line in lines:
	marks = line.split(',')
	math = int(marks[0])
	physics = int(marks[1])
	chemistry = int(marks[2])
	sum = math + physics + chemistry
	print(line +', sum = '+ str(sum))
'''
#return, break, continue

def do_something():
	for x in range(10):
		if(x == 3):
			continue
			#break
			#return
		print(x)
	print('hahaha')

do_something()

def factorial(n):
	if(n <= 1):
		return 1
	else:
		return n * factorial(n - 1)	

print(factorial(1000))




























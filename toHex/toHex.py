#!/usr/bin/env python3

str = "hello"

list = []

for i in str:
  list.append(hex(ord(i)))

print(list)

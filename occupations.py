f = open("occupations.csv","r")
a = f.readlines()
dic ={}
percentage ={}
print a
del a[0]
del a[len(a) -1]
print a
x = 
v = 0.0
for line in a:
    if line[0] == '"':
        occ = line.split('"')
        dic['"' + occ[1] + '"'] = float(occ[2][1:len(occ[2])])
        if x == 0:
            percentage[float(occ[2][1:len(occ[2])]) / 99.8] = '"' + occ[1] + '"'
            x +=1
            val = float(occ[2][1:len(occ[2])])
        else:
            percentage[float(occ[2][1:len(occ[2])]) / 99.8 + val] = '"' + occ[1] + '"'
            val += float(occ[2][1:len(occ[2])]) / 99.8
            x += 1
                        
    else:
        occ = line.split(",")
        dic[occ[0]] = float(occ[1])
        percentage[float(occ[1])] = occ[0]
    
for occupation in dic:
    
    print occupation
    print dic[occupation]

Function LaRousse(A,B)
    Arrays x, y
    
/* First Array Value */
    x[0] = A
    y[0] = B
    z[]
    while A > 0

/* Create Result Array */
            if x[i] % 2 != 0
                z add x[i]
            else
                z add 0
    
/* Create Multiplier Array */
            if A % 2 == 0
                x add A / 2
            else
                x add (A - 1) / 2
            
/* Create Multiplikand Array */
            B = B * 2
            y add B
    sum = 0
    for i = 0 in z.length
        sum = sum + z[i]
    return sum
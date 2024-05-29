def check(midday, a, k, b, m, x):
    return (x <= midday * a + midday * b - midday // k * a - midday // m * b)

a, k, b, m, x = map(int, input().split())
l = 0
r = 100000000000000000000000
while r - l > 1:
    mid = (l + r) // 2
    if check(mid, a, k, b, m, x): r = mid
    else: l = mid
print(l + 1)
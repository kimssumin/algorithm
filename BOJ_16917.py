# 양념 반 후라이드 반
# brute force

A, B, C, X, Y = map(int, input().split())

# A a + 1/2 C c >= X, B b + 1/2 C c >= Y
# 0 <= a <= X, 0 <= b <= Y, 0 <= c <= max(2(X - a), 2(Y-a));
# 후라이드와 양념을 각각 한마리씩 사는 것보다 반반으로 두마리를 사는 것이 비싼 경우 각각 구매

if A + B < 2 * C:
    print(A * X + B * Y)
else:
    print(2 * C * min(X, Y) + min(A, 2*C) *
          max(0, X-Y) + min(B, 2*C)*max(0, Y-X))
  #  X>Y 라면,  반반 치킨 최소갯수 Y 개 만큼 우선 반반 치킨을 사고 (Y 해결), X 남는 양만큼을 한마리치킨과 반마리치킨중에 더 싼걸로

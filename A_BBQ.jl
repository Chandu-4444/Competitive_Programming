n = parse(Int64, readline())

arr = map(n->parse(Int64, n),  split(readline()))

arr = sort(arr, rev=true)

println(sum(arr[2:2:2n]))

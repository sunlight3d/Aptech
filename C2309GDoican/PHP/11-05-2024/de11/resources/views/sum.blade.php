<!DOCTYPE html>
<html>
<head>
    <title>Tính Tổng</title>
</head>
<body>
    <h1>Tính Tổng Hai Số</h1>    
    <form method="POST" action="{{ route('calculate') }}"> 
        @csrf
    <!--Gọi đến hàm calculate trong controller hiện tại(CalculationController) -->
        <input type="number" name="number1" placeholder="Nhập số thứ nhất" required>
            <input type="number" name="number2" placeholder="Nhập số thứ hai" required>
            <button type="submit">Tính Tổng</button>    
    </form>    
    @if (isset($sum))
        <h2>{{ $sum }}</h2>    
    @endif
</body>
</html>

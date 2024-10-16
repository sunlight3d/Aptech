<form action="/employees/{{ $employee->id }}"
    method="post">
    @csrf
    @method('PUT')
    <input type="text" name="employee_name" value="{{$employee->employee_name}}">
    <input type="text" name="post" value="{{$employee->post}}">
    <input type="text" name="salary" value="{{$employee->salary}}">
    <input type="submit" value="Update">
</form>

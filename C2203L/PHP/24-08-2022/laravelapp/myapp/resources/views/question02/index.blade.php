<h1>This is index of Question2</h1>
{{-- <h2>{{$dbname}}</h2> --}}



<table style="width:50%">
    <tr>
      <th>Emp No</th>
      <th>Emp Name</th>
      <th>Post</th>
      <th>Emp Salary</th>
      <th></th>
    </tr>
    @foreach ($employees as $employee)
        <tr>
            <td>{{$employee->id}}</td>
            <td>{{$employee->employee_name}}</td>
            <td>{{$employee->post}}</td>
            <td>{{$employee->salary}}</td>
            <td><a href="/employees/{{$employee->id}}">
                Edit</a></td>
            {{-- <a href="/employee_list.php?deletedEmployeeNo=<?php echo $employee->employeeNo; ?>">
            Delete</a> --}}
        </td>
        </tr>
    @endforeach
  </table>
  <form action="{{url('employees')}}" method="POST">
    @csrf
    <p>Employee name</p>
    <input type="text" name="employee_name">
    <p>Post</p>
    <input type="text" name="post">
    <p>Salary</p>
    <input type="text" name="salary">
    <input type="submit" value="Save infor">
  </form>

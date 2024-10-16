<h1>This is People.index</h1>
<table>
    <tr>
        <th>
            ID
        </th>
        <th>
            Name
        </th>
        <th>
            Gender
        </th>
        <th>
            DOB
        </th>
        <th>

        </th>
    </tr>
    @foreach ($people as $person)
        <tr>
            <td>{{$person->id}}</td>
            <td>{{$person->name}}</td>
            <td>{{$person->gender == 0 ? 'Female' : 'Male'}}</td>
            <td>{{$person->dateOfBirth}}</td>
            <td>
                <form
                    method="GET">
                    @csrf
                    <a href="{{route('people.edit', $person->id)}}">Update</a>
                </form>
                <form
                action="{{route('people.destroy', $person->id)}}"
                method="POST">
                    @csrf
                    @method('DELETE')
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    @endforeach
</table>

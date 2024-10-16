<h1>This is Items.index</h1>
<table>
    <tr>
        <th>
            ID
        </th>
        <th>
            Name
        </th>
    </tr>
    @foreach ($items as $item)
        <tr>
            <td>{{$item->id}}</td>
            <td>{{$item->name}}</td>
        </tr>
    @endforeach
</table>
@for ($i = 0; $i < $totalPages; $i++)
    <a href="{{route('items.index', [
        'page' => $i
    ])}}">{{$i == 0 ? 'First' : (($i == $totalPages - 1) ? 'Last' : $i)}}</a>
@endfor

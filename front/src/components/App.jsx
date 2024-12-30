import { useState } from 'react'
import '../styling/index.css'

const testObjects = [
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Psycho",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Psycho",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Psycho",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Psycho",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Psycho",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Psycho",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Psycho",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Psycho",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Psycho",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Psycho",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Optical",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Optical",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Optical",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Optical",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Optical",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Optical",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Optical",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Optical",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Optical",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Optical",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Nature",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Nature",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Nature",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Nature",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Nature",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Nature",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Nature",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Nature",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Nature",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Nature",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Ki",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Ki",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Ki",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Ki",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Ki",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Ki",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Ki",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Ki",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Ki",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Ki",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Faith",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Faith",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Faith",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Faith",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Faith",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Faith",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Faith",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Faith",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Faith",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  },
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Faith",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4"
  }
]

const testHeaders = 'ID,NAME,TYPE,SCHOOL,COST,STR,USE,RANGE,HOMING';


function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <h1>Base</h1>
    </>
  )
}

export default App

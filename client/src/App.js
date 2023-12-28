import logo from './logo.svg';
import { useEffect, useState } from 'react';


function App() {

  const [lastname, setLastName] = useState('');
  const [lastnameQuery, setLastnameQuery] = useState('AND');
  const [firstname, setFirstname] = useState('');
  const [firstnameQuery, setFirstnameQuery] = useState('AND');
  const [address, setAddress] = useState('');
  const [addressQuery, setAddressQuery] = useState('AND');
  const [administrationLevel, setAdministrationLevel] = useState('');
  const [administrationLevelQuery, setAdministrationLevelQuery] = useState('AND');
  const [content, setContent] = useState('');
  const [contentQuery, setcontentQuery] = useState('AND');

  const [city, setCity] = useState('');
  const [radius, setRadius] = useState('');

  const [list, setList] = useState([{
    id: 1,
    title: 'Helllo'
  }]);

  const indexFiles = async () => {
    let result = await (await fetch('/api/index', { method: 'POST' })).text();
    alert(result);
  };

  const test = async () => {
    let result = await (await fetch('/api/contracts')).text();
    alert(result);
  };

  useEffect(() => {
    //test();
  }, []);

  const handleSearch = async (e) => {
    e.preventDefault();
    // Perform any action here with form values (e.g., display or process the entered data)
    console.log('First Name:', firstname);
    console.log('Last Name:', lastname);
    console.log('Address:', address);
    console.log('Administration Level:', administrationLevel);
    let result = await (await fetch('/api/search', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
        // Add other headers if required
      },
      body: JSON.stringify({
        firstname: firstname,
        firstnameQuery: firstnameQuery,
        lastname: lastname,
        lastnameQuery: lastnameQuery,
        address: address,
        addressQuery: addressQuery,
        administrationLevel: administrationLevel,
        administrationLevelQuery: administrationLevelQuery,
        content: content,
        contentQuery: contentQuery,
        city: city,
        radius: radius
      })
    })).text();
    console.log(result);
  };


  return (
    <div>
      <button onClick={e => indexFiles()} class="text-blue-500 hover:underline py-2 px-4 rounded cursor-pointer bg-transparent border border-blue-500 hover:bg-blue-500 hover:text-white">
        Read Files
      </button>
      <div className="max-w-screen-sm mx-auto mt-5">
        <form className="mt-8 space-y-6" onSubmit={handleSearch}>
          <div className="rounded-md shadow-sm space-y-4">
            <h3 className="text-3xl font-bold underline">Search Contract</h3>
            <div className="my-2 flex gap-1">
              <label htmlFor="firstname" className="block text-gray-600 w-1/3">
                First Name:
              </label>
              <div className='w-3/12'>
                <select
                  id="firstname"
                  name="firstname"
                  value={firstnameQuery}
                  onChange={e => setFirstnameQuery(e.target.value)}
                  className="appearance-none relative block w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
                >
                  <option value="AND" selected={"AND" === firstnameQuery}>AND</option>
                  <option value="OR" selected={"OR" === firstnameQuery}>OR</option>
                  <option value="NOT" selected={"NOT" === firstnameQuery}>NOT</option>
                </select>
              </div>
              <div className='w-full'>
                <input
                  id="first-name"
                  name="first-name"
                  type="text"
                  value={firstname}
                  onChange={e => setFirstname(e.target.value)}
                  className="appearance-none relative block w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
                  placeholder="First Name"
                />
              </div>
            </div>
            <div className="my-2 flex gap-1" >
              <label htmlFor="additional-info" className="block text-gray-600 w-1/3">
                Last Name:
              </label>
              <div className='w-3/12'>
                <select
                  id="uprava"
                  name="uprava"
                  value={lastnameQuery}
                  onChange={e => setLastnameQuery(e.target.value)}
                  className="appearance-none relative block w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
                >
                  <option value="AND" selected={"AND" === lastnameQuery}>AND</option>
                  <option value="OR" selected={"OR" === lastnameQuery}>OR</option>
                  <option value="NOT" selected={"NOT" === lastnameQuery}>NOT</option>
                </select>
              </div>
              <div className='w-full'>
                <input
                  id="last-name"
                  name="last-name"
                  type="text"
                  value={lastname}
                  onChange={e => setLastName(e.target.value)}
                  className="appearance-none relative block w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
                  placeholder="Last Name"
                />
              </div>
            </div>
            <div className="my-2 flex gap-1">
              <label htmlFor="additional-info" className="block text-gray-600 w-1/3">
                Administration:
              </label>
              <div className='w-3/12'>
                <select
                  id="uprava"
                  name="uprava"
                  value={administrationLevelQuery}
                  onChange={e => setAdministrationLevelQuery(e.target.value)}
                  className="appearance-none relative block w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
                >
                  <option value="AND" selected={"AND" === administrationLevelQuery}>AND</option>
                  <option value="OR" selected={"OR" === administrationLevelQuery}>OR</option>
                  <option value="NOT" selected={"NOT" === administrationLevelQuery}>NOT</option>
                </select>
              </div>
              <div className='w-full'>
                <select
                  id="uprava"
                  name="uprava"
                  value={administrationLevel}
                  onChange={e => setAdministrationLevel(e.target.value)}
                  className="appearance-none relative block w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
                >
                  <option value="" selected>Choose Administration Level</option>
                  <option value="opstina">Opstina</option>
                  <option value="grad">Grad</option>
                  <option value="pokrajina">Pokrajina</option>
                  <option value="drzava">Drzava</option>
                </select>
              </div>
            </div>
            <div className="my-2 flex gap-1">
              <label htmlFor="additional-info" className="block text-gray-600 w-1/3">
                Address:
              </label>
              <div className='w-3/12'>
                <select
                  id="uprava"
                  name="uprava"
                  value={addressQuery}
                  onChange={e => setAddressQuery(e.target.value)}
                  className="appearance-none relative block w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
                >
                  <option value="AND" selected={"AND" === addressQuery}>AND</option>
                  <option value="OR" selected={"OR" === addressQuery}>OR</option>
                  <option value="NOT" selected={"NOT" === addressQuery}>NOT</option>
                </select>
              </div>
              <div className='w-full'>
                <input
                  id="address"
                  name="address"
                  type="text"
                  value={address}
                  onChange={e => setAddress(e.target.value)}
                  className="appearance-none relative block w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
                  placeholder="Address"
                />
              </div>
            </div>
            <div className="my-2 flex gap-1">
              <label htmlFor="additional-info" className="block text-gray-600 w-1/3">
                Content:
              </label>
              <div className='w-3/12'>
                <select
                  id="uprava"
                  name="uprava"
                  value={contentQuery}
                  onChange={e => setcontentQuery(e.target.value)}
                  className="appearance-none relative block w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
                >
                  <option value="AND" selected={"AND" === contentQuery}>AND</option>
                  <option value="OR" selected={"OR" === contentQuery}>OR</option>
                  <option value="NOT" selected={"NOT" === contentQuery}>NOT</option>
                </select>
              </div>
              <div className='w-full'>
                <textarea
                  id="content"
                  name="content"
                  value={content}
                  onChange={(e) => setContent(e.target.value)}
                  rows={4}
                  className="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
                  placeholder="Enter content here"
                />
              </div>
            </div>
          </div>
          <hr />
          <div>
            <h2>Search By Geolocation:</h2>
            <div className='my-2'>
              <input
                id="address"
                name="address"
                type="text"
                value={city}
                onChange={e => setCity(e.target.value)}
                className="appearance-none relative block w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
                placeholder="City"
              />
            </div>
            <div className='my-2'>
              <input
                id="radius"
                name="radius"
                type="number"
                value={radius}
                onChange={e => setRadius(e.target.value)}
                className="appearance-none relative block w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 sm:text-sm"
                placeholder="Radius"
              />
            </div>
          </div>
          <div>
            <button
              type="submit"
              className="group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500"
            >
              Search
            </button>
          </div>
        </form>
      </div>

      <div className='mx-auto w-2/4 mt-4'>
        <h2 className='my-2'>Results:</h2>
        {list.map(item => {
          return (
            <div class="flex justify-between">
              <div class="text-lg font-bold place-self-center">{item.title}</div>
              <div class="ml-4">
                <button class="text-blue-500 hover:underline py-2 px-4 rounded cursor-pointer bg-transparent border border-blue-500 hover:bg-blue-500 hover:text-white">
                  Download
                </button>
              </div>
            </div>
          )
        })}
      </div>


    </div>
  );
}

export default App;

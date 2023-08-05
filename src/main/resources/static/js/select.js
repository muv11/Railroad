let regions = [];
async function getRegionList() {
    const response = await fetch('http://localhost:8080/api/regions');
    regions = await response.json();
    let select = document.getElementById('regionSelect');
    for (let i = 0; i < regions.length; i++){
        let option = document.createElement('option');
        option.text = regions[i].name;
        select.appendChild(option);
    }
}

getRegionList().then();

function getSelectedRegion() {
    let selectedRegion = document.getElementById('regionSelect');
    return selectedRegion.options[selectedRegion.selectedIndex].text;
}

let cities = [];
async function getCityListByRegion() {
    // await getRegionList();
    let region = getSelectedRegion();
    const response = await fetch(`http://localhost:8080/api/cities/${region}`);
    cities = await response.json();
    console.log(cities);
    let select = document.getElementById('citySelect');
    for (let i = 0; i < cities.length; i++){
        let option = document.createElement('option');
        option.text = cities[i].name;
        select.appendChild(option);
    }
}

//getCityListByRegion().then();
document.getElementById('regionSelect').addEventListener('change', async function () {
    await getCityListByRegion();
});

let depotTypes = []
async function getDepotTypeList() {
    const response = await fetch('http://localhost:8080/api/depot_types');
    depotTypes = await response.json();
    let select = document.getElementById('depotTypeSelect');
    for (let i = 0; i < depotTypes.length; i++){
        let option = document.createElement('option');
        option.text = depotTypes[i].name;
        select.appendChild(option);
    }
}
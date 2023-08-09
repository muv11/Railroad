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
await getRegionList();

function getSelectedRegion() {
    let selectedRegion = document.getElementById('regionSelect');
    return selectedRegion.options[selectedRegion.selectedIndex].text;
}

function removeOptions(select) {
    while (select.options.length > 0) {
        select.remove(0);
    }
}

let cities = [];
async function getCityListByRegion() {
    let select = document.getElementById('citySelect');
    removeOptions(select);
    let region = getSelectedRegion();
    const response = await fetch(`http://localhost:8080/api/cities/${region}`);
    cities = await response.json();
    for (let i = 0; i < cities.length; i++){
        let option = document.createElement('option');
        option.text = cities[i].name;
        select.appendChild(option);
    }
}
await getCityListByRegion();

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
        option.text = depotTypes[i].type;
        select.appendChild(option);
    }
    select.size = depotTypes.length;
}
await getDepotTypeList();
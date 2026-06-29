import { useState, useEffect } from "react";


function PlantForm({onAddPlant, onEditPlant, plantData}){

    const [name, setName] = useState("");
    const [waterInt, setWaterInt] = useState("");
    const [quantity, setQuantity] = useState("");
    const [description, setDescription] = useState("");
    const [category, setCategory] = useState("");
    const [light, setLight] = useState("");
    const [imgLink, setImgLink] = useState("");

    useEffect(() => {
        console.log("Efecto activado con:", plantData);
        if(plantData){
            setName(plantData.name);
            setWaterInt(plantData.wateringInterval); // Revisa que coincida con el nombre de tu variable
            setQuantity(plantData.quantity);
            setDescription(plantData.description);
            setCategory(plantData.category);
            setLight(plantData.light);
            setImgLink(plantData.imgLink);
        }
    }, [plantData]);

    const handleSubmit = (e) => {
        e.preventDefault();

        const newPlantData = {
            id: plantData ? plantData.id : null,
            name: name,
            category: category,
            description: description,
            wateringInterval: waterInt,
            quantity: quantity,
            light: light,
            imgLink: imgLink
        }

        if(plantData){
            onEditPlant(newPlantData);
        } else{
            onAddPlant(newPlantData);
        }
    }

    
    return (
    // 1. Cambiamos el style={{...}} por tu nueva clase boho-form
    <form onSubmit={handleSubmit} className="boho-form">
        {/* Usamos el título boho-title con tamaño intermedio */}
        <h2 className="boho-title text-4xl text-center mb-4">Add a new plant</h2>

        <label htmlFor="name" className="boho-form-label">Name: </label>
        <input type="text" id="name" placeholder="e.g. Mandrake" className="boho-form-input" value={name} onChange={(e) => setName(e.target.value)} /> 

        <label htmlFor="waterInt" className="boho-form-label">Watering Interval (Days): </label>
        <input type="number" id="waterInt" className="boho-form-input" value={waterInt} onChange={(e) => setWaterInt(e.target.value)} /> 

        <label htmlFor="quantity" className="boho-form-label">Quantity:</label>
        <input type="number" id="quantity" className="boho-form-input" value={quantity} onChange={(e) => setQuantity(e.target.value)}/> 

        <label htmlFor="description" className="boho-form-label">Description:</label>
        <textarea id="description" className="boho-form-input h-20 resize-none" value={description} onChange={(e) => setDescription(e.target.value)}></textarea>
        
        <label htmlFor="category" className="boho-form-label">Category:</label>
        <select id="category" value={category} className="boho-form-input" onChange={(e) => setCategory(e.target.value)}>
            <option value="">-- Select a Category --</option>
            <option value="FOLIAGE_INTERIOR">Foliage Interior</option>
            <option value="FERN">Fern</option>
            <option value="FLOWERING">Flowering</option>
            <option value="TRAILING">Trailing</option>
        </select>

        <label htmlFor="light" className="boho-form-label">Light Requirement:</label>
        <select id="light" value={light} className="boho-form-input" onChange={(e) => setLight(e.target.value)}>
            <option value="">-- Select Light --</option>
            <option value="LOW_LIGHT">Low Light</option>
            <option value="INDIRECT_BRIGHT">Indirect Bright</option>
            <option value="DIRECT_SUN">Direct Sun</option>
        </select>

        <label htmlFor="imgLink" className="boho-form-label">Image URL:</label>
        <input type="text" id="imgLink" placeholder="https://example.com" className="boho-form-input" value={imgLink} onChange={(e) => setImgLink(e.target.value)} />

        {/* El botón de guardar con su clase herbolaria */}
        <button type="submit" className="boho-btn-save">Save Plant</button>
    </form>
)
}
export default PlantForm;
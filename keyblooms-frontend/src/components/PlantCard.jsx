function PlantCard({ plant, onDelete, onEdit }) {
  return (
    <div className="boho-card max-w-sm">
      
      <h3 className="boho-title text-3xl mb-1">{plant.name}</h3>

      <p className="text-md mb-1">
        <span className="text-luna-burgundy font-bold ml-1">{plant.description}</span>
      </p>

      <p className="text-md mb-1">
        <span className="boho-badge">I have: </span> 
        <span className="text-luna-burgundy font-bold ml-1">{plant.quantity} plants</span>
      </p>
      
      <p className="text-md mb-1">
        <span className="boho-badge">Category:</span> 
        <span className="text-luna-burgundy font-bold ml-1">{plant.category}</span>
      </p>

      <p className="text-md mb-1">
        <span className="boho-badge">Water every:</span> 
        <span className="text-luna-burgundy font-bold ml-1">{plant.wateringInterval} days</span>
      </p>


      <img 
        alt={plant.name} 
        src={plant.imgLink} 
        className="w-full h-48 object-cover rounded-xl mb-4 border border-boho-green/10" 
      />

      <div className="flex gap-3 mt-2 items-center">
        <button onClick={() => onEdit(plant)} className="boho-btn-edit">
          Edit
        </button>
        <button onClick={() => onDelete(plant.id)} className="boho-btn-delete">
          Delete Plant
        </button>
      </div>

    </div>
  );
}
export default PlantCard;
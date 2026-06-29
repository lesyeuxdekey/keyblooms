
function PlantNav({currentView, onViewChange}) {
  return (
    <div className="flex justify-center gap-4 mb-8">
      
      {/* Botón 1: Lista de Inventario */}
      <button 
        className={`boho-nav-btn ${currentView === "list" ? "active" : ""}`} 
        onClick={() => onViewChange("list")}
      >
        📜 Inventory List
      </button>
      
      {/* Botón 2: Agregar Planta */}
      <button 
        className={`boho-nav-btn ${currentView === "add" ? "active" : ""}`} 
        onClick={() => onViewChange("add")}
      >
        🌱 Add Botanical
      </button>
      
      {/* Botón 3: Buscar */}
      <button 
        className={`boho-nav-btn ${currentView === "search" ? "active" :""}`} 
        onClick={() => onViewChange("search")}
      >
        🔍 Search Plants
      </button>

    </div>
  );
}

export default PlantNav;

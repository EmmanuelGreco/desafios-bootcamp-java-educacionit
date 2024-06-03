function agregarCategoria() {
    const categoriasDiv = document.getElementById('categorias');
    const categoriaNueva = document.createElement('div');
    categoriaNueva.classList.add('categoria');
    categoriaNueva.innerHTML = `
        <input type="text" name="categoriaNombre" placeholder="Nombre de la categoría" required>
        <input type="number" name="categoriaPorcentaje" placeholder="%" min="0" required>
        <button type="button" class="eliminar-boton" onclick="eliminarCategoria(this)">Eliminar</button>
    `;
    categoriasDiv.appendChild(categoriaNueva);
}

function eliminarCategoria(button) {
    const categoriaDiv = button.parentElement;
    categoriaDiv.remove();
}

/* No hago validación de texto, pero sí de ingresos y porcentajes */
function calcularPresupuesto() {
    const ingresoElemento = document.getElementById('ingreso');
    const ingreso = parseFloat(ingresoElemento.value);
    if (isNaN(ingreso) || ingreso <= 0) {
        alert('Por favor, ingrese un monto válido de ingresos!');
        return;
    }
    
    const categoriaNombres = document.getElementsByName('categoriaNombre');
    const categoriaPorcentajes = document.getElementsByName('categoriaPorcentaje');
    let totalPorcentaje = 0;
    let resultados = '';

    for (let i = 0; i < categoriaPorcentajes.length; i++) {
        const porcentaje = parseFloat(categoriaPorcentajes[i].value);
        if (isNaN(porcentaje) || porcentaje < 0) {
            alert('Por favor, ingrese porcentajes válidos y mayores o iguales a 0!');
            return;
        }
        totalPorcentaje += porcentaje;
    }

    if (totalPorcentaje !== 100) {
        alert('Los porcentajes deben sumar 100%!\n');
        return;
    }

    for (let i = 0; i < categoriaNombres.length; i++) {
        const categoriaNombre = categoriaNombres[i].value;
        const categoriaPorcentaje = parseFloat(categoriaPorcentajes[i].value);
        const cantidad = (ingreso * categoriaPorcentaje) / 100;
        resultados += `<p>${categoriaNombre}: $${cantidad.toFixed(2)}</p>`;
    }

    document.getElementById('resultado').innerHTML = resultados;
}
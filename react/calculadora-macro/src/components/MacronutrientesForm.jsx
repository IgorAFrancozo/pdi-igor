import {useState} from "react";
import styles from './MacronutrientesForm.module.css';
import api from "../services/api.js";

function MacronutrientesForm() {
    const [form, setForm] = useState({
        peso: '',
        altura: '',
        idade: '',
        genero: 'MASCULINO',
        objetivo: 'CUTTING',
        percentualDeGordura: '',
        nivelAtividade: 'MODERADO',
    });

    const [resultado, setResultado] = useState(null);

    const handleChange = (e) => {
        setForm({...form, [e.target.name]: e.target.value});
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await api.post('/macronutrientes', form);
            setResultado(response.data);
        } catch (err) {
            console.error('Erro ao calcular:', err);
        }
    };

    const handleClear = () => {
        setForm({
            peso: '',
            altura: '',
            idade: '',
            genero: 'MASCULINO',
            objetivo: 'CUTTING',
            percentualDeGordura: '',
            nivelAtividade: 'MODERADO',
        });
        setResultado(null);
    };

    return (
        <div className="min-h-screen bg-gray-100 dark:bg-gray-900 text-gray-800 dark:text-gray-100 py-10 px-4">
            <div className="max-w-md mx-auto bg-white dark:bg-gray-800 p-8 rounded-xl shadow-lg">
                <h1 className="text-2xl font-bold text-center mb-6">Calculadora de Macronutrientes PDI Igor</h1>
                <br/>
                <h3 className="text-2xl font-bold text-center mb-6">Insira os dados para o cálculo</h3>
                <form onSubmit={handleSubmit} className="space-y-4">
                    <input
                        type="number"
                        name="peso"
                        placeholder="Peso (kg)"
                        value={form.peso}
                        onChange={handleChange}
                        required
                        className="w-full p-2 border border-gray-300 dark:border-gray-700 rounded bg-gray-50 dark:bg-gray-700"
                    />
                    <input
                        type="number"
                        name="altura"
                        placeholder="Altura (cm)"
                        value={form.altura}
                        onChange={handleChange}
                        required
                        className="w-full p-2 border border-gray-300 dark:border-gray-700 rounded bg-gray-50 dark:bg-gray-700"
                    />
                    <input
                        type="number"
                        name="idade"
                        placeholder="Idade"
                        value={form.idade}
                        onChange={handleChange}
                        required
                        className="w-full p-2 border border-gray-300 dark:border-gray-700 rounded bg-gray-50 dark:bg-gray-700"
                    />
                    <input
                        type="number"
                        name="percentualDeGordura"
                        placeholder="% Gordura (opcional)"
                        value={form.percentualDeGordura}
                        onChange={handleChange}
                        className="w-full p-2 border border-gray-300 dark:border-gray-700 rounded bg-gray-50 dark:bg-gray-700"
                    />
                    <select
                        name="genero"
                        value={form.genero}
                        onChange={handleChange}
                        className="w-full p-2 border border-gray-300 dark:border-gray-700 rounded bg-gray-50 dark:bg-gray-700"
                    >
                        <option value="MASCULINO">Masculino</option>
                        <option value="FEMININO">Feminino</option>
                    </select>
                    <select
                        name="objetivo"
                        value={form.objetivo}
                        onChange={handleChange}
                        className="w-full p-2 border border-gray-300 dark:border-gray-700 rounded bg-gray-50 dark:bg-gray-700"
                    >
                        <option value="CUTTING">Cutting</option>
                        <option value="BULKING">Bulking</option>
                        <option value="MANUTENCAO">Manutenção</option>
                    </select>
                    <select
                        name="nivelAtividade"
                        value={form.nivelAtividade}
                        onChange={handleChange}
                        className="w-full p-2 border border-gray-300 dark:border-gray-700 rounded bg-gray-50 dark:bg-gray-700">
                        <option value="SEDENTARIO">Sedentário</option>
                        <option value="LEVE">Leve - 1 a 2 dias por semana</option>
                        <option value="MODERADO">Moderado - 3 a 5 dias por semana</option>
                        <option value="PESADO">Pesado - 6 a 7 dias por semana</option>
                        <option value="ATLETA">Atleta - 2x por dia</option>
                    </select>
                    <div className="flex justify-between">
                        <button
                            type="submit"
                            className="bg-blue-600 hover:bg-blue-700 text-white font-semibold py-2 px-4 rounded">
                            Calcular
                        </button>
                        <button
                            type="button"
                            onClick={handleClear}
                            className="bg-red-600 hover:bg-red-700 text-white font-semibold py-2 px-4 rounded">
                            Limpar
                        </button>
                    </div>
                </form>

                {resultado && (
                    <div
                        className="mt-6 p-6 rounded-2xl bg-blue-100 dark:bg-blue-900 shadow-lg border border-blue-300 dark:border-blue-700 transition-colors duration-300">
                        <h4 className="text-xl font-semibold text-blue-900 dark:text-blue-100 mb-4">
                            Resultado:
                        </h4>
                        <div className="space-y-2 text-base text-blue-800 dark:text-blue-100">
                            <p>
                                <span className="font-medium">Gasto Calórico: </span>{' '}
                                <span className="text-lg font-bold text-blue-900 dark:text-orange-200">
        {resultado.calorias.toFixed(2)} kcal </span>
                            </p>
                            <p>
                                <span className="font-medium">Proteínas: </span>{' '}
                                <span className="text-lg font-bold text-green-600 dark:text-green-300">
        {resultado.proteinas.toFixed(2)} g </span>
                            </p>
                            <p>
                                <span className="font-medium">Carboidratos: </span>{' '}
                                <span className="text-lg font-bold text-yellow-600 dark:text-yellow-300">
        {resultado.carboidratos.toFixed(2)} g </span>
                            </p>
                            <p>
                                <span className="font-medium">Gorduras: </span>{' '}
                                <span className="text-lg font-bold text-red-600 dark:text-red-400">
        {resultado.gorduras.toFixed(2)} g </span>
                            </p>
                        </div>
                    </div>
                )}
            </div>
        </div>
    );
}

export default MacronutrientesForm;
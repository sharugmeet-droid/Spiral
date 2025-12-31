import java.util.Scanner

fun generateSpiralMatrix(n: Int): Array<IntArray> {
    val matrix = Array(n) { IntArray(n) }

    var top = 0
    var bottom = n - 1
    var left = 0
    var right = n - 1
    var value = 1

    while (top <= bottom && left <= right) {

        // Left to Right
        for (i in left..right) {
            matrix[top][i] = value++
        }
        top++

        // Top to Bottom
        for (i in top..bottom) {
            matrix[i][right] = value++
        }
        right--

        // Right to Left
        if (top <= bottom) {
            for (i in right downTo left) {
                matrix[bottom][i] = value++
            }
            bottom--
        }

        // Bottom to Top
        if (left <= right) {
            for (i in bottom downTo top) {
                matrix[i][left] = value++
            }
            left++
        }
    }
    return matrix
}

fun printMatrix(matrix: Array<IntArray>) {
    for (row in matrix) {
        for (value in row) {
            print(String.format("%4d", value))
        }
        println()
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    println("=== Spiral Matrix Generator ===")
    print("Enter matrix size (n): ")
    val n = scanner.nextInt()

    val spiralMatrix = generateSpiralMatrix(n)

    println("\nSpiral Matrix:")
    printMatrix(spiralMatrix)
}
